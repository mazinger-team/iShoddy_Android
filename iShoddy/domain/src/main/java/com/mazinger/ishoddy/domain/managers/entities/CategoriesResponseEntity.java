package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponseEntity
{
    //-- TODO: testing --
    @SerializedName("categories") private List<CategoryEntity> result;
    //--

    public List<CategoryEntity> getResult()
    {
        return result;
    }
}
