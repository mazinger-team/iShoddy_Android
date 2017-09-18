package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponseEntity
{
    // https://stackoverflow.com/questions/42252063/deserializing-a-complex-json-several-nested-elements-with-gson

    @SerializedName("listCategoriesOutputType")
    private Result result;

    public List<CategoryEntity> getResult()
    {
        return  this.result.getCategories();
    }

    public class Result
    {
        @SerializedName("categories")
        private List<CategoryEntity> categories;

        public List<CategoryEntity> getCategories()
        {
            return categories;
        }
    }
}
