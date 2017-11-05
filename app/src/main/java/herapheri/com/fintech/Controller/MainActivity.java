package herapheri.com.fintech.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import herapheri.com.fintech.Model.Cobrand;
import herapheri.com.fintech.R;
import herapheri.com.fintech.Utils.APIError;
import herapheri.com.fintech.Utils.ErrorUtils;
import herapheri.com.fintech.Utils.RetrofitAPI;
import herapheri.com.fintech.Utils.ServiceGenerator;
import herapheri.com.fintech.Utils.SessionGlobals;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Main Activity where the lifecycle starts.
 *
 * @author Rekhansh (rpanchal@uncc.edu)
 */
public class MainActivity extends AppCompatActivity {
    Button next;
    MediaType mediaType = MediaType.parse("application/json");
    private MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lend It");

        next = (Button) findViewById(R.id.btn_login);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                materialDialog = new MaterialDialog.Builder(MainActivity.this)
                        .title("Logging in...")
                        .content("Please wait")
                        .progress(true, 0)
                        .progressIndeterminateStyle(true)
                        .cancelable(false)
                        .show();

                //Pre-configured for easy login of user. For Demo purposes only.
                String cobrandLogin = getString(R.string.Cobrand_Login);
                String pass = "3cffef4e-5209-4375-9473-c4058635a0e4";

                String requestBody = "{" +
                        "\"cobrand\":      {" +
                        "\"cobrandLogin\": " + "\"" + cobrandLogin + "\"" + "," +
                        "\"cobrandPassword\": " + "\"" + pass + "\"" + "," +
                        "\"locale\": \"en_US\"" +
                        "}" +
                        "}";

                RequestBody body = RequestBody.create(mediaType, requestBody);

                RetrofitAPI retrofitAPI = ServiceGenerator.createServiceYodleeSetup(RetrofitAPI.class);
                Call<Cobrand> cobrandCall = retrofitAPI.doCobrandLogin(body);

                cobrandCall.enqueue(new Callback<Cobrand>() {
                    @Override
                    public void onResponse(@NonNull Call<Cobrand> call, @NonNull Response<Cobrand> response) {

                        if (response.isSuccessful() && response.body() != null) {
                            Cobrand cobrand = response.body();

                            //Set cob-session.
                            SessionGlobals.setCobSession(cobrand.getSession().getCobSession());
                            callUserLogin();
                        } else {
                            displayError(response);
                            materialDialog.dismiss();
                        }

                    }

                    @Override
                    public void onFailure(@NonNull Call<Cobrand> call, @NonNull Throwable t) {
                        Log.d("response", "Failure");
                    }
                });
            }
        });
    }

    private void callUserLogin() {

        RetrofitAPI retrofitAPI = ServiceGenerator.createServiceYodlee(RetrofitAPI.class, 1);

        //Pre-configured user.
        String userName = "sbMemd308d35f2c4a8af430af782b5e93c113ca1";
        String password = "sbMemd308d35f2c4a8af430af782b5e93c113ca1#123";

        String requestBody = "{" +
                "\"user\":      {" +
                "\"loginName\": " + "\"" + userName + "\"" + "," +
                "\"password\": " + "\"" + password + "\"" + "," +
                "\"locale\": \"en_US\"" +
                "}" +
                "}";

        RequestBody body1 = RequestBody.create(mediaType, requestBody);
        Call<ResponseBody> userLoginCall = retrofitAPI.doUserLogin(body1);
        userLoginCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NonNull Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Response User ", "Successful");
                    ResponseBody body = response.body();
                    Log.d("body", body.toString());
                    try {
                        JSONObject jsonObject = new JSONObject(body.string());
                        jsonObject = jsonObject.getJSONObject("user");
                        jsonObject = jsonObject.getJSONObject("session");
                        SessionGlobals.setUserSession(jsonObject.getString("userSession"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (SessionGlobals.getUserSession() != null && SessionGlobals.getCobSession() != null)
                        checkAccountDetails();

                } else {
                    materialDialog.dismiss();
                    displayError(response);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseBody> call, @NonNull Throwable t) {
                Log.d("Response User ", "Failed");
                materialDialog.dismiss();
            }
        });
    }


    private void checkAccountDetails() {


        RetrofitAPI retrofitAPI = ServiceGenerator.createServiceYodleeAfterAuth(RetrofitAPI.class, 2);
        Call<ResponseBody> accountCall = retrofitAPI.getAccounts();
        accountCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ResponseBody body = response.body();
                    double balance = (double) 0;
                    try {
                        JSONObject jsonObject = new JSONObject(body.string());

                        /*
                         * Logic for accessing all the account balances of the person.
                         */
                        JSONArray jsonArray = jsonObject.getJSONArray("account");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            jsonObject1 = jsonObject1.getJSONObject("availableBalance");
                            balance += jsonObject1.getDouble("amount");
                        }

                        //Assumption: All balances are mentioned in USD.
                        SessionGlobals.setTotalBalance(((float) balance));

                    } catch (JSONException e) {
                        SessionGlobals.setTotalBalance((float) 0);
                        e.printStackTrace();
                    } catch (IOException e) {
                        SessionGlobals.setTotalBalance((float) 0);
                        e.printStackTrace();
                    }

                    //Write a logic to count all balances of the person.
                    Log.d("Account Balance is", SessionGlobals.getTotalBalance() + "");
                    materialDialog.dismiss();

                    Intent i = new Intent(MainActivity.this, TabbarActivity.class);
                    startActivity(i);

                } else {
                    materialDialog.dismiss();
                    displayError(response);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("Account", "Fetch failure.");
            }
        });
    }


    /**
     * Function to parse the response body and display alert dialog box.
     *
     * @param response Response received from the server.
     */
    private void displayError(Response response) {

        // Parse the response body
        APIError error = ErrorUtils.parseError(response);

        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(error.getMessage())
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Do nothing.
                    }
                })
                .show();
    }
}

