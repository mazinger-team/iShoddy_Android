package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;

import org.json.JSONObject;

public class PostRegisterUserInteractorImpl implements PostRegisterUserInteractor {

    private NetworkPostManager postManager;
    private JSONObject jsonRegister;

    // Recibo parámetros
    public PostRegisterUserInteractorImpl(@NonNull final NetworkPostManager postmanager, @NonNull final JSONObject jsonObject) {
        this.postManager = postmanager;
        this.jsonRegister = jsonObject;
    }


    @Override
    public void execute(@NonNull final PostRegisterUserInteractorCompletion completion,
                        @NonNull final JSONObject jsonRegister,
                        @Nullable final InteractorErrorCompletion onError) {
        // manager.execute(completion, jsonRegister, onError);

        if (this.postManager == null) {
            if (onError == null) {
                throw new IllegalStateException("Network manager can't be null");
            } else {
                onError.onError("");
            }
        }

        this.postManager.execute(new PostRegisterUserInteractorCompletion() {
                                     @Override
                                     public void completion(@NonNull JSONObject json) {
                                         Log.d("iShoddy", "json response from interactor es: " + json);
                                         // if (completion != null) {
                                         // Future actions
                                         // }
                                     }
                                 }, jsonRegister,
                new ManagerErrorCompletion() {
                    @Override
                    public void onError(String errorDescription) {
                        if (onError != null) {
                            onError.onError(errorDescription);
                        }
                    }
                });

    }


}
