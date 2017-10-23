package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.json.JSONObject;

public interface PostRegisterUserInteractor {

    public void execute(@NonNull final PostRegisterUserInteractorCompletion completion,
                        @NonNull final JSONObject jsonRegister,
                        @Nullable final InteractorErrorCompletion onError);

}
