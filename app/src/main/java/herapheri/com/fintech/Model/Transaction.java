package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rekhansh on 11/4/2017.
 * Model for a transaction from Block Chain.
 */

public class Transaction {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("renterId")
    @Expose
    private String renterId;

    @SerializedName("lenderId")
    @Expose
    private String lenderId;

    @SerializedName("itemId")
    @Expose
    private String itemId;

    @SerializedName("startTime")
    @Expose
    private Long startTime;

    @SerializedName("endTime")
    @Expose
    private Long endTime;

    @SerializedName("beforeImageURL")
    @Expose
    private String beforeImageURL;

    @SerializedName("afterImageURL")
    @Expose
    private String afterImageURL;

    //From Yodley.
    @SerializedName("price")
    @Expose
    private Money price;

    //From Block-chain.
    @SerializedName("transactionCost")
    @Expose
    private String transactionCost;

    @SerializedName("isLeaseBroken")
    @Expose
    private Boolean isLeaseBroken;

    @SerializedName("isInsuranceOpted")
    @Expose
    private Boolean isInsuranceOpted;
    @SerializedName("extraCost")
    @Expose
    private Float extraCost;
    private Boolean tracking;

    public Boolean getTracking() {
        return tracking;
    }

    public void setTracking(Boolean tracking) {
        this.tracking = tracking;
    }

    //Use when you get data from yodley.
    public void updatePriceYodleyToBlockChain() {
        this.price.setAmount(String.valueOf(this.transactionCost));
        this.price.setCurrency("USD");
    }

    //Use when you get data from block chain.
    public void updatePriceBlockChainToYodley() {
        this.setTransactionCost(this.getPrice().getAmount());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public String getBeforeImageURL() {
        return beforeImageURL;
    }

    public void setBeforeImageURL(String beforeImageURL) {
        this.beforeImageURL = beforeImageURL;
    }

    public String getAfterImageURL() {
        return afterImageURL;
    }

    public void setAfterImageURL(String afterImageURL) {
        this.afterImageURL = afterImageURL;
    }

    public String getTransactionCost() {
        return transactionCost;
    }

    public void setTransactionCost(String transactionCost) {
        this.transactionCost = transactionCost;
    }

    public Boolean getLeaseBroken() {
        return isLeaseBroken;
    }

    public void setLeaseBroken(Boolean leaseBroken) {
        isLeaseBroken = leaseBroken;
    }

    public Boolean getInsuranceOpted() {
        return isInsuranceOpted;
    }

    public void setInsuranceOpted(Boolean insuranceOpted) {
        isInsuranceOpted = insuranceOpted;
    }

    public Float getExtraCost() {
        return extraCost;
    }

    public void setExtraCost(Float extraCost) {
        this.extraCost = extraCost;
    }
}
