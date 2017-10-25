package com.mazinger.ishoddy.domain.managers.cache;

import android.content.Context;

import com.mazinger.ishoddy.domain.managers.entities.LoginEntity;
import com.mazinger.ishoddy.domain.managers.entities.LoginResponseEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserResponseEntity;
import com.mazinger.ishoddy.domain.managers.jsonparser.LoginResponseJsonParser;
import com.mazinger.ishoddy.domain.managers.jsonparser.UserJsonParser;
import com.mazinger.ishoddy.domain.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

public class SaveUserDataAndTokenManagerImpl implements SaveUserDataAndTokenManager{

    private WeakReference<Context> contextWeakReference;

    public SaveUserDataAndTokenManagerImpl(Context contextWeakReference) {
        this.contextWeakReference = new WeakReference<Context>(contextWeakReference);
    }


    @Override
    public void execute(Runnable completion, JSONObject json) {

        // Save user date in user singleton
        User user = User.getInstance();

        try {
            user = User.of(json.getString("email"), json.getString("_id"));

            if (json.getString("token").length() != 0){
                user.setToken(json.getString("token"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        completion.run();

    }
}
