package com.mazinger.ishoddy.domain.model;

import java.util.List;

public interface CategoriesIterable
{
    long size();
    Category get(long index);
    List<Category> allCategories();
}
