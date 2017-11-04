package herapheri.com.fintech.Utils;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for storing all session globals.
 */

class SessionGlobals {

    private static String authToken;

    SessionGlobals() {

    }

    static String getAuthToken() {
        return authToken;
    }

    public static void setAuthToken(String authToken) {
        SessionGlobals.authToken = authToken;
    }
}
