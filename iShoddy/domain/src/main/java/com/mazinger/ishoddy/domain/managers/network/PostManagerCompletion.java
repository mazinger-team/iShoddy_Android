package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.UserEntity;

import org.json.JSONObject;

public interface PostManagerCompletion {
    void completion(@NonNull final UserEntity userEntity);

}
