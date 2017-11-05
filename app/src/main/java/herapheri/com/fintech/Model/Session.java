package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rekhansh on 11/5/2017.
 * Data model for session.
 */

public class Session {

    @SerializedName("cobSession")
    @Expose
    private String cobSession;
    @SerializedName("userSession")
    @Expose
    private String userSession;

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    public String getCobSession() {
        return cobSession;
    }

    public void setCobSession(String cobSession) {
        this.cobSession = cobSession;
    }
}
