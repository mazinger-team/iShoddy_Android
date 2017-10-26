package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class UserEntity {

    @SerializedName("_id") private String id;
    @SerializedName("email") private String email;
    @SerializedName("password") private String password;
    @SerializedName("name") private String name;
    @SerializedName("lastName") private String lastname;
    @SerializedName("telephone") private String telephone;
    @SerializedName("ratingAccumulate") private String ratingAccumulate;
    @SerializedName("ratingVotes") private String ratingVotes;
    @SerializedName("rating") private String rating;
    @SerializedName("modificationDay") Date date;


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRatingAccumulate() {
        return ratingAccumulate;
    }

    public String getRatingVotes() {
        return ratingVotes;
    }

    public String getRating() {
        return rating;
    }

    public Date getDate() {
        return date;
    }
}
