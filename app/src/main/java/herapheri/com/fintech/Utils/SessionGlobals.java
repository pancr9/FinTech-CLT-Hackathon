package herapheri.com.fintech.Utils;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for storing all session globals.
 */

public class SessionGlobals {

    private static String cobSession;
    private static String userSession;

    SessionGlobals() {

    }

    public static String getUserSession() {
        return userSession;
    }

    public static void setUserSession(String userSession) {
        SessionGlobals.userSession = userSession;
    }

    static String getCobSession() {
        return cobSession;
    }

    public static void setCobSession(String authToken) {
        SessionGlobals.cobSession = authToken;
    }
}
