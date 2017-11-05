package herapheri.com.fintech.Utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Rekhansh on 11/4/2017.
 * Retrofit API for getting and sending data.
 *
 * @author Rekhansh Panchal (rpanchal@uncc.edu)
 */

public interface RetrofitAPI {

    // Login
    @FormUrlEncoded
    @POST("staffLogin")
    Call<ResponseBody> doLogin(@Field("userName") String username,
                               @Field("password") String password);

    //Log Out
    @GET("logout")
    Call<ResponseBody> doLogOut(@Query("authToken") String authToken);

    /*
     * GET calls.
     */
    //Call to fetch account and rest details.
    //http://129.150.95.24:8001/bankAccounts
    @GET
    Call<ResponseBody> getAccountDetails(@Header("jSessionId") String jsessionid);


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
