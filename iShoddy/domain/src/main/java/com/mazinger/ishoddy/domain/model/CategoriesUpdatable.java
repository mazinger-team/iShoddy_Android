package com.mazinger.ishoddy.domain.model;

public interface CategoriesUpdatable
{
    void add(Category category);
    void delete(Category category);
    void update(Category newCategory, long index);
}
