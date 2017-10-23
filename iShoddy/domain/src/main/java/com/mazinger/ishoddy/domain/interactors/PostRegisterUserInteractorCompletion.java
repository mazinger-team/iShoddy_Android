package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;

import org.json.JSONObject;

public interface PostRegisterUserInteractorCompletion {

    void completion(@NonNull final JSONObject json);
}
