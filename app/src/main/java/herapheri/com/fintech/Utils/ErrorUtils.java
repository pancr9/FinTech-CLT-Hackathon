package herapheri.com.fintech.Utils;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by Rekhansh on 11/4/2017.
 * Error Utils for parsing the errors.
 *
 * @author Rekhansh Panchal (rpanchal@uncc.edu)
 */


public class ErrorUtils {

    public static APIError parseError(Response<?> response) {
        Converter<ResponseBody, APIError> converter =
                ServiceGenerator.getRetrofit().responseBodyConverter(
                        APIError.class,
                        new Annotation[0]);
        APIError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }
        return error;
    }
}