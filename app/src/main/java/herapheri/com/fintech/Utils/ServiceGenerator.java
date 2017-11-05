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

    private static final String BASE_URL_YODLEE = "https://www";
    private static final String BASE_URL_BLOCK_CHAIN = "https://www";
    private static Boolean isYodleeUsed = false;

    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);
    private static Dispatcher dispatcher = new Dispatcher();

    private static OkHttpClient.Builder httpClientYodlee = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Authorization", "Bearer " + SessionGlobals.getAuthToken())
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

    private static OkHttpClient.Builder httpClientBlockChain = new OkHttpClient.Builder()
            .addInterceptor(new Interceptor() {
                @Override
                public Response intercept(@NonNull Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("Content-Type", "application/json")
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

    private static Gson gson = new GsonBuilder()
            .registerTypeAdapter(Date.class, new DateDeserializer())
            .create();

    private static Retrofit.Builder builderYodlee = new Retrofit.Builder()
            .baseUrl(BASE_URL_YODLEE)
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit.Builder builderBlockChain = new Retrofit.Builder()
            .baseUrl(BASE_URL_BLOCK_CHAIN)
            .addConverterFactory(GsonConverterFactory.create(gson));

    private static Retrofit retrofitYodlee = builderYodlee.client(httpClientYodlee.build()).build();

    private static Retrofit retrofitBlockChain = builderBlockChain.client(httpClientBlockChain.build()).build();

    /* package */
    static Retrofit getRetrofit() {
        if (isYodleeUsed)
            return retrofitYodlee;
        else return retrofitBlockChain;
    }

    public static <S> S createServiceYodlee(Class<S> retrofitAPI) {
        isYodleeUsed = true;
        return retrofitYodlee.create(retrofitAPI);
    }

    public static <S> S createServiceBlockChain(Class<S> retrofitAPI) {
        isYodleeUsed = false;
        return retrofitBlockChain.create(retrofitAPI);
    }

}
