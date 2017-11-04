package herapheri.com.fintech.Utils;

import android.util.Log;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for logging errors.
 *
 * @author Rekhansh Panchal (rpanchal@uncc.edu)
 */

public class APIError {

    private int statusCode;
    private String message;

    public APIError() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        Log.d("Status code is: ", String.valueOf(statusCode));
        return message;
    }
}
