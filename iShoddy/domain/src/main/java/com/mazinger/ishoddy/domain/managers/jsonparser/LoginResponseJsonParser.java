package com.mazinger.ishoddy.domain.managers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.LoginEntity;
import com.mazinger.ishoddy.domain.managers.entities.LoginResponseEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserResponseEntity;

import org.json.JSONObject;

import java.io.Reader;
import java.io.StringReader;

public class LoginResponseJsonParser {

    public LoginEntity parser(JSONObject response) {

        if (response == null) {
            return null;
        }

        LoginEntity loginEntity = null;

        try {
            Gson gson = new GsonBuilder().create();
            // Reader reader = new StringReader(response);
            // LoginResponseEntity loginResponseEntity = gson.fromJson(reader, LoginResponseEntity.class);
            // loginEntity = loginResponseEntity.getResult();
            // loginEntity = gson.fromJson(reader, LoginEntity.class);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginEntity;
    }

}

