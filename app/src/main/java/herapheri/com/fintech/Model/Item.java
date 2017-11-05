package herapheri.com.fintech.Model;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Rekhansh on 11/4/2017.
 * Model class for Items for lending.
 */

public class Item implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("weight")
    @Expose
    private Float weight;

    @SerializedName("brand")
    @Expose
    private String brand;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("manufactureYear")
    @Expose
    private Integer manufactureYear;

    @SerializedName("lenderId")
    @Expose
    private String lenderId;

    @SerializedName("renterId")
    @Expose
    private String renterId;

    @SerializedName("location")
    @Expose
    private Location location;

    @SerializedName("isActive")
    @Expose
    private Boolean isActive;

    @SerializedName("rating")
    @Expose
    private Float rating;

    @SerializedName("pricePerday")
    @Expose
    private Float pricePerday;

    @SerializedName("imageHash")
    @Expose
    private String imageHash;

    @SerializedName("timeRented")
    @Expose
    private Long timeRented;

    @SerializedName("timeReturned")
    @Expose
    private Long timeReturned;

    @SerializedName("currentTransactionId")
    @Expose
    private String currentTransactionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getPricePerday() {
        return pricePerday;
    }

    public void setPricePerday(Float pricePerday) {
        this.pricePerday = pricePerday;
    }

    public String getImageHash() {
        return imageHash;
    }

    public void setImageHash(String imageHash) {
        this.imageHash = imageHash;
    }

    public Long getTimeRented() {
        return timeRented;
    }

    public void setTimeRented(Long timeRented) {
        this.timeRented = timeRented;
    }

    public Long getTimeReturned() {
        return timeReturned;
    }

    public void setTimeReturned(Long timeReturned) {
        this.timeReturned = timeReturned;
    }

    public String getCurrentTransactionId() {
        return currentTransactionId;
    }

    public void setCurrentTransactionId(String currentTransactionId) {
        this.currentTransactionId = currentTransactionId;
    }
}
