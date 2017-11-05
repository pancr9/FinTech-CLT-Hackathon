package herapheri.com.fintech.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Rekhansh on 11/4/2017.
 * Model class for User.
 */

public class User {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("loginName")
    @Expose
    private String loginName;
    @SerializedName("roleType")
    @Expose
    private String roleType;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("address")
    @Expose
    private Address address;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("accessTokens")
    @Expose
    private AccessTokens accessTokens;
    @SerializedName("session")
    @Expose
    private Session session;
    /* Values from block chain. */
    @SerializedName("rating")
    @Expose
    private Float rating;

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AccessTokens getAccessTokens() {
        return accessTokens;
    }

    public void setAccessTokens(AccessTokens accessTokens) {
        this.accessTokens = accessTokens;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}