package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

public class LoginEntity {

    @SerializedName("_id") private String id;
    @SerializedName("email") private String email;
    @SerializedName("x-auth") private String token;


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
