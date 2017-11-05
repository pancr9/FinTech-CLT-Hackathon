package herapheri.com.fintech.Utils;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for storing all session globals.
 */

class SessionGlobals {

    private static String cobSession;

    SessionGlobals() {

    }

    static String getCobSession() {
        return cobSession;
    }

    public static void setCobSession(String authToken) {
        SessionGlobals.cobSession = authToken;
    }
}
