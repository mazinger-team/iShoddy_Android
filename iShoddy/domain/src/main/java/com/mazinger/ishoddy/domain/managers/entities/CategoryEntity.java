package com.mazinger.ishoddy.domain.managers.entities;

import com.google.gson.annotations.SerializedName;

public class CategoryEntity
{
    @SerializedName("id") private long id;
    @SerializedName("name") private String name;
    @SerializedName("active") private boolean active;
    @SerializedName("modificationDate") private String modificationDate;
    @SerializedName("urlLogo") private String urlLogo;

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isActive()
    {
        return active;
    }

    public String getModificationDate()
    {
        return modificationDate;
    }

    public String getUrlLogo()
    {
        return urlLogo;
    }
}
