package com.mazinger.ishoddy.domain.managers.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mazinger.ishoddy.domain.interactors.PostRegisterUserInteractorCompletion;

import org.json.JSONObject;

public interface NetworkPostManager {

    void postDataToServer(@NonNull final PostManagerCompletion completion,
                          @NonNull final JSONObject jsonRegister,
                          @Nullable final ManagerErrorCompletion errorCompletion);

}


