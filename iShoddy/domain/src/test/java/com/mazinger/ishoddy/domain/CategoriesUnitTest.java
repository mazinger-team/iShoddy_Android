package com.mazinger.ishoddy.domain;

import com.mazinger.ishoddy.domain.model.Categories;
import com.mazinger.ishoddy.domain.model.Category;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoriesUnitTest
{
    @Test
    public void after_creation_categories_size_is_zero() throws Exception
    {
        Categories sut = new Categories();

        assertEquals(0, sut.size());
    }

    @Test
    public void category_adding_one_category_size_is_one() throws Exception
    {
        Categories sut = new Categories();

        sut.add(Category.of(1, "Abogados", true));

        assertEquals(1, sut.size());
    }

    @Test
    public void categories_adding_one_category_and_deleting_size_is_zero() throws Exception
    {
        Categories sut = new Categories();

        Category category = Category.of(1, "Abogados", true);
        sut.add(category);
        sut.delete(category);

        assertEquals(0, sut.size());
    }

    @Test
    public void categories_adding_one_category_and_getting_returns_that_category() throws Exception
    {
        Categories sut = new Categories();

        Category category = Category.of(1, "Abogados", true);
        sut.add(category);

        assertEquals(category.getId(), sut.get(0).getId());
        assertEquals(category.getName(), sut.get(0).getName());
    }

    @Test
    public void categories_adding_serveral_categories_returns_all_categories() throws Exception
    {
        Categories sut = new Categories();

        for (int i = 0; i < 10; i++)
        {
            Category category = Category.of(i, "My category " + i, true);
            sut.add(category);
        }

        assertEquals(10, sut.size());
        assertEquals(10, sut.allCategories().size());
        assertEquals(0, sut.allCategories().get(0).getId());
        assertEquals("My category 0", sut.allCategories().get(0).getName());
    }
}































