package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

public class UserResponseEntity {

    @SerializedName("result") private UserEntity result;

    public UserEntity getResult() {
        return result;
    }

}
