package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by realm on 11/5/2017.
 * Data Model for Networth
 */

public class Networth {
    @SerializedName("asset")
    @Expose
    private String asset;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("networth")
    @Expose
    private String networth;

    @SerializedName("liability")
    @Expose
    private String liability;

    @SerializedName("historicalBalances")
    @Expose
    private String historicalBalances;

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNetworth() {
        return networth;
    }

    public void setNetworth(String networth) {
        this.networth = networth;
    }

    public String getLiability() {
        return liability;
    }

    public void setLiability(String liability) {
        this.liability = liability;
    }

    public String getHistoricalBalances() {
        return historicalBalances;
    }

    public void setHistoricalBalances(String historicalBalances) {
        this.historicalBalances = historicalBalances;
    }
}
