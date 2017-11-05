package herapheri.com.fintech.Utils;

import herapheri.com.fintech.Model.Cobrand;
import herapheri.com.fintech.Model.User;
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
    Call<User> doUserLogin(@Body RequestBody userParam);

    //Call for Logout
    @POST("/{cobrandName}/v1/cobrand/logout")
    Call<ResponseBody> doLogOut(@Path("cobrandName") String cobrandName);

    //Get User.
    @GET("/{cobrandName}/v1/user")
    Call<User> getUserDetails(@Path("cobrandName") String cobrandName);


    /*
     * GET calls.
     */
    //Call to fetch account and rest details.


    /*
     * POST calls.
     */
    //Card Money Transfer.
    //http://tasgroup.cashless30.apiblueprint.org/postsales/card/transfer


    //Card Top-up.
    //http://tasgroup.cashless30.apiblueprint.org/postsales/card/topup

    //Card Withdrawal


    //Card Details
    //http://tasgroup.cashless30.apiblueprint.org/postsales/card/detail

    //Generate Session ID for accessing OBDX services.
    //http://129.150.95.24:8001/access


    //PUT calls.


}