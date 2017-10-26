package com.mazinger.ishoddy.domain.managers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.CategoriesResponseEntity;
import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class CategoriesJsonParser
{
    public List<CategoryEntity> parser(String response)
    {
        List<CategoryEntity> categoryEntities = null;

        try {
            Gson gson = new GsonBuilder().create();

            Reader reader = new StringReader(response);
            CategoriesResponseEntity categoriesResponseEntity = gson.fromJson(reader, CategoriesResponseEntity.class);
            categoryEntities = categoriesResponseEntity.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return categoryEntities;
    }
}
