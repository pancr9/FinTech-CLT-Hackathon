package herapheri.com.fintech.Utils;

import java.util.ArrayList;

import herapheri.com.fintech.Model.Cobrand;
import herapheri.com.fintech.Model.Item;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Rekhansh on 11/4/2017.
 * Retrofit API for getting and sending data.
 *
 * @author Rekhansh Panchal (rpanchal@uncc.edu)
 */

public interface RetrofitAPI {


    //Call for Cobrand Login.
    @POST("cobrand/login")
    Call<Cobrand> doCobrandLogin(@Body RequestBody cobrandParam);

    //Call for user login.
    @POST("user/login")
    Call<ResponseBody> doUserLogin(@Body RequestBody userParam);

    //Call for Logout
    @POST("/{cobrandName}/v1/cobrand/logout")
    Call<ResponseBody> doLogOut(@Path("cobrandName") String cobrandName);

    //Get all accounts of the person. (Ideally returns accounts, but modified to return account arraylist.)
    //Function to fetch all active bank accounts.
    @GET("accounts?status=ACTIVE&container=bank")
    Call<ResponseBody> getAccounts();


    /*
     * API call to fetch all the items.
     * Assumption: Data received does not belong to the users posting.
     */
    @GET("get")
    Call<ArrayList<Item>> getItemsForRenting();


}