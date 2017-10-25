package com.mazinger.ishoddy.domain.interactors;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mazinger.ishoddy.domain.managers.entities.UserEntity;
import com.mazinger.ishoddy.domain.managers.network.ManagerErrorCompletion;
import com.mazinger.ishoddy.domain.managers.network.NetworkPostManager;
import com.mazinger.ishoddy.domain.managers.network.PostManagerCompletion;
import com.mazinger.ishoddy.domain.model.User;

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
        // manager.postDataToServer(completion, jsonRegister, onError);

        if (this.postManager == null) {
            if (onError == null) {
                throw new IllegalStateException("Network manager can't be null");
            } else {
                onError.onError("");
            }
        }

        this.postManager.postDataToServer(new PostManagerCompletion() {

               @Override
               public void completion(@NonNull String token) {

                   Log.d("iShoddy", "token " + token);

                   if (completion != null) {
                       completion.completion(token);
                   }

               }
        },
        jsonRegister,
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
