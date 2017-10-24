package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.managers.entities.UserEntity;
import com.mazinger.ishoddy.domain.model.User;

import org.json.JSONObject;

public interface PostRegisterUserInteractorCompletion {

    void completion(@NonNull final User user);
}
