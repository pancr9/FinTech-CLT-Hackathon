package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rekhansh on 11/5/2017.
 * Model class for Cobrand.
 */

public class Cobrand {

    @SerializedName("cobrandId")
    @Expose
    private String cobrandId;

    @SerializedName("applicationId")
    @Expose
    private String applicationId;

    @SerializedName("locale")
    @Expose
    private String locale;

    @SerializedName("session")
    @Expose
    private Session session;

    public String getCobrandId() {
        return cobrandId;
    }

    public void setCobrandId(String cobrandId) {
        this.cobrandId = cobrandId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
