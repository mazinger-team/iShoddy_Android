package com.mazinger.ishoddy.domain.managers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.CategoriesResponseEntity;
import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserEntity;
import com.mazinger.ishoddy.domain.managers.entities.UserResponseEntity;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class UserJsonParser {

    public UserEntity parser(String response) {

        if (response == null) {
            return null;
        }

        UserEntity userEntity = null;

        try {
            Gson gson = new GsonBuilder().create();
            Reader reader = new StringReader(response);
            UserResponseEntity userResponseEntity = gson.fromJson(reader, UserResponseEntity.class);
            userEntity = userResponseEntity.getResult();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return userEntity;
    }


}
