package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

public class LoginResponseEntity {

    @SerializedName("result") private LoginEntity result;

    public LoginEntity getResult() {
        return result;
    }

}
