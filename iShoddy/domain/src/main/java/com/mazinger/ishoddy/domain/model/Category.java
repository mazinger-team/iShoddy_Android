package com.mazinger.ishoddy.domain.model;

import android.support.annotation.NonNull;

public class Category
{
    private String name;
    private long id;
    private boolean active;
//    private String fechaModificacion:
//    private String imageUrl;

    public static Category of(long id, String name, boolean active) {

        Category category = new Category(id, name, active);

        category.setId(id);
        category.setName(name);
        category.setActive(active);

        return category;
    }

    private Category(long id, String name, boolean active)
    {
        this.name = name;
        this.id = id;
        this.active = active;
    }

    public Category(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public Category setName(@NonNull final String name)
    {
        this.name = name;
        return this;
    }

    public long getId()
    {
        return id;
    }

    public Category setId(long id)
    {
        this.id = id;
        return this;
    }

    public boolean isActive()
    {
        return active;
    }

    public Category setActive(boolean active)
    {
        this.active = active;
        return this;
    }
}