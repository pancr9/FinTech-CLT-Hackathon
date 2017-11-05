package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by realm on 11/5/2017.
 * Data Model for Networth
 */

public class Networth {
    @SerializedName("asset")
    @Expose
    private Money asset;

    @SerializedName("date")
    @Expose
    private Date date;

    @SerializedName("networth")
    @Expose
    private Money networth;

    @SerializedName("liability")
    @Expose
    private Money liability;


    public Money getAsset() {
        return asset;
    }

    public void setAsset(Money asset) {
        this.asset = asset;
    }

    public Money getNetworth() {
        return networth;
    }

    public void setNetworth(Money networth) {
        this.networth = networth;
    }

    public Money getLiability() {
        return liability;
    }

    public void setLiability(Money liability) {
        this.liability = liability;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
