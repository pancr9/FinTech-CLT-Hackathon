package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rekhansh on 11/4/2017.
 * Data model for Money.
 */

public class Money {

    @SerializedName("amount")
    @Expose
    private String amount;

    @SerializedName("currency")
    @Expose
    private String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
