package herapheri.com.fintech.Utils;

import herapheri.com.fintech.Model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    @FormUrlEncoded
    @POST("{cobrandName}/login")
    Call<ResponseBody> doCobrandLogin(@Field("cobrandLogin") String cobrandLogin,
                                      @Field("cobrandPassword") String cobrandPassword,
                                      @Path("cobrandName") String cobrandName);

    //Call for user login.
    @FormUrlEncoded
    @POST("user/login")
    Call<ResponseBody> doUserLogin(@Field("loginName") String loginName,
                                   @Field("password") String password);


    //Call for Logout
    @POST("/{cobrandName}/v1/user/logout")
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
