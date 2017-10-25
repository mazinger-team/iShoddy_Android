package com.mazinger.ishoddy.domain.interactors.cache;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface SaveUserDataAndTokenInteractor {

    void execute(Runnable completion, JSONObject json);

}
