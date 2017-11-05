package herapheri.com.fintech.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import herapheri.com.fintech.Model.Cobrand;
import herapheri.com.fintech.Model.User;
import herapheri.com.fintech.R;
import herapheri.com.fintech.Utils.RetrofitAPI;
import herapheri.com.fintech.Utils.ServiceGenerator;
import herapheri.com.fintech.Utils.SessionGlobals;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button next;
    MediaType mediaType = MediaType.parse("application/json");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String cobrandLogin = getString(R.string.Cobrand_Login);
        String cobrandPassword = getString(R.string.CobrandPassword);
        RequestBody body = RequestBody.create(mediaType, "{\"cobrand\":{\"cobrandLogin\":\"" + cobrandLogin + "\",\"cobrandPassword\":\"" + cobrandPassword + "\"}}");

        RetrofitAPI retrofitAPI = ServiceGenerator.createServiceYodleeSetup(RetrofitAPI.class);
        Call<Cobrand> cobrandCall = retrofitAPI.doCobrandLogin(body);

        cobrandCall.enqueue(new Callback<Cobrand>() {
            @Override
            public void onResponse(@NonNull Call<Cobrand> call, @NonNull Response<Cobrand> response) {


                if (response.isSuccessful() && response.body() != null) {
                    Cobrand cobrand = response.body();

                    //Set cob-session.
                    SessionGlobals.setCobSession(cobrand.getSession().getCobSession());


                }
            }

            @Override
            public void onFailure(@NonNull Call<Cobrand> call, @NonNull Throwable t) {
                Log.d("response", "Failure");
            }
        });


        next = (Button) findViewById(R.id.btn_login);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Input is not null.
                //Call user login.
                callUserLogin();
            }
        });


    }

    private void callUserLogin() {

        RetrofitAPI retrofitAPI = ServiceGenerator.createServiceYodlee(RetrofitAPI.class);

        //Pre-onfigured user.
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
        Call<User> userLoginCall = retrofitAPI.doUserLogin(body1);
        userLoginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("Response User ", "Successful");

                    Intent i = new Intent(MainActivity.this, TabbarActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

                Log.d("Response User ", "Failed");
            }
        });

    }
}

