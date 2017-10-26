package com.mazinger.ishoddy.domain.interactors.cache;

import com.mazinger.ishoddy.domain.managers.cache.SaveUserDataAndTokenManager;

import org.json.JSONObject;

public class SaveUserDataAndTokenInteractorImpl implements SaveUserDataAndTokenInteractor {

    private SaveUserDataAndTokenManager manager;

    public SaveUserDataAndTokenInteractorImpl(SaveUserDataAndTokenManager manager, JSONObject response) {
        this.manager = manager;
    }


    @Override
    public void execute(Runnable completion, JSONObject json) {
        manager.execute(completion, json);
    }

}
