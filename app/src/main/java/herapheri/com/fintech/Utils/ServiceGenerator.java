package herapheri.com.fintech.Utils;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for creating links to the base URL.
 *
 * @author Rekhansh Panchal (rpanchal@uncc.edu)
 */

public class ServiceGenerator {

    private static final String BASE_URL_YODLEE = "https://developer.api.yodlee.com/ysl/restserver/v1/";
    private static final String BASE_URL_YODLEE_443 = "https://developer.api.yodlee.com:443/ysl/restserver/v1/";
    private static final String BASE_URL_CLOUD = "https://mcs-gse00011680.mobileenv.us2.oraclecloud.com:443/mobile/custom/getItems/";

    private static Integer type;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static Dispatcher dispatcher = new Dispatcher();

    private static OkHttpClient.Builder httpClientYodlee = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("Authorization", "cobSession=" + SessionGlobals.getCobSession())
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            })
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .dispatcher(dispatcher);


    private static OkHttpClient.Builder httpClientYodleeCob = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("cache-control", "no-cache")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            })
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .dispatcher(dispatcher);

    private static OkHttpClient.Builder httpClientYodleeAfterAuth = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("cache-control", "no-cache")
                            .header("Authorization", "cobSession=" + SessionGlobals.getCobSession() + ",userSession=" + SessionGlobals.getUserSession())
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            })
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .dispatcher(dispatcher);

    private static OkHttpClient.Builder httpClientCloud = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
                            .header("cache-control", "no-cache")
                            .header("Oracle-Mobile-Backend-Id", "10cc6d0f-50b4-46d4-af4f-c71fee672755")
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            })
            .readTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .dispatcher(dispatcher);

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateDeserializer())
            .create();

    private static Retrofit.Builder builderYodlee = new Retrofit.Builder()
            .baseUrl(BASE_URL_YODLEE)
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit.Builder builderCloudData = new Retrofit.Builder()
            .baseUrl(BASE_URL_CLOUD)
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit.Builder builderYodleeAfterAuth = new Retrofit.Builder()
            .baseUrl(BASE_URL_YODLEE_443)
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit retrofitYodlee = builderYodlee.client(httpClientYodlee.build()).build();

    private static Retrofit retrofitYodleeCob = builderYodlee.client(httpClientYodleeCob.build()).build();

    private static Retrofit retrofitYodleeAfterAuth = builderYodleeAfterAuth.client(httpClientYodleeAfterAuth.build()).build();

    private static Retrofit retrofitCloud = builderCloudData.client(httpClientCloud.build()).build();

    /* package */
    static Retrofit getRetrofit() {
        switch (type) {
            case 1:
                return retrofitYodleeCob;
            case 2:
                return retrofitYodleeAfterAuth;
            default:
                return retrofitYodlee;
        }
    }

    public static <S> S createServiceYodlee(Class<S> retrofitAPI, int serviceType) {
        type = serviceType;
        return retrofitYodlee.create(retrofitAPI);
    }

    public static <S> S createServiceYodleeSetup(Class<S> retrofitAPI) {

        return retrofitYodleeCob.create(retrofitAPI);
    }

    public static <S> S createServiceYodleeAfterAuth(Class<S> retrofitAPI, int serviceType) {

        return retrofitYodleeAfterAuth.create(retrofitAPI);
    }

    public static <S> S createServiceForCloud(Class<S> retrofitAPI, int serviceType) {

        return retrofitCloud.create(retrofitAPI);
    }
}