package com.mazinger.ishoddy.domain.managers.cache;

import com.google.gson.JsonObject;

import org.json.JSONObject;

public interface SaveUserDataAndTokenManager {
    void execute(final  Runnable completion, final JSONObject json);
}
