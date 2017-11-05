package herapheri.com.fintech.Utils;

/**
 * Created by Rekhansh on 11/4/2017.
 * Class for storing all session globals.
 */

public class SessionGlobals {

    private static String cobSession;
    private static String userSession;
    private static Float totalBalance;

    SessionGlobals() {

    }

    public static Float getTotalBalance() {
        return totalBalance;
    }

    public static void setTotalBalance(Float totalBalance) {
        SessionGlobals.totalBalance = totalBalance;
    }

    public static String getUserSession() {
        return userSession;
    }

    public static void setUserSession(String userSession) {
        SessionGlobals.userSession = userSession;
    }

    public static String getCobSession() {
        return cobSession;
    }

    public static void setCobSession(String authToken) {
        SessionGlobals.cobSession = authToken;
    }
}
