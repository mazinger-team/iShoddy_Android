package com.mazinger.ishoddy.domain.model;

import java.util.LinkedList;
import java.util.List;

public class Categories implements CategoriesIterable, CategoriesUpdatable
{
    private List<Category> categories;

    public Categories()
    {

    }

    // lazy getter
    private List<Category> getCategories()
    {
        if (categories == null)
        {
            categories = new LinkedList<>();
        }

        return  categories;
    }

    @Override
    public void add(Category category)
    {
        getCategories().add(category);
    }

    @Override
    public void delete(Category category)
    {
        getCategories().remove(category);
    }

    @Override
    public void update(Category newCategory, long index)
    {
        getCategories().set((int)index, newCategory);
    }

    @Override
    public long size()
    {
        return getCategories().size();
    }

    @Override
    public Category get(long index)
    {
        return getCategories().get((int)index);
    }

    @Override
    public List<Category> allCategories()
    {
        List<Category> listCopy = new LinkedList<>();

        for (Category category : getCategories()) {

            listCopy.add(category);
        }

        return listCopy;
    }
}






























