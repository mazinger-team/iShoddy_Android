package com.mazinger.ishoddy.domain;

import com.mazinger.ishoddy.domain.model.Professional.Professional;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;
import com.mazinger.ishoddy.domain.model.Category;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProfessionalsUnitTest
{
    @Test
    public void after_creation_professionals_size_is_zero() throws Exception
    {
        Professionals sut = new Professionals();

        assertEquals(0, sut.size());
    }

    @Test
    public void category_adding_one_category_size_is_one() throws Exception
    {
        Professionals sut = new Professionals();

        Category category = Category.of(1, "Abogados", true);

        sut.add(Professional.of("1", "Barman Antonio", "Barman Antonio", category, "logo", 1.0, 1, 1, 1.0));

        assertEquals(1, sut.size());
    }

    @Test
    public void professionals_adding_one_category_and_deleting_size_is_zero() throws Exception
    {
        Professionals sut = new Professionals();

        Category category = Category.of(1, "Abogados", true);

        Professional professional = Professional.of("1", "Barman Antonio", "Barman Antonio", category, "logo", 1.0, 1, 1, 1.0);

        sut.add(professional);
        sut.delete(professional);

        assertEquals(0, sut.size());
    }

    @Test
    public void professionals_adding_one_category_and_getting_returns_that_category() throws Exception
    {
        Professionals sut = new Professionals();

        Category category = Category.of(1, "Abogados", true);

        Professional professional = Professional.of("1", "Barman Antonio", "Barman Antonio", category, "logo", 1.0, 1, 1, 1.0);

        sut.add(professional);

        assertEquals(professional.getId(), sut.get(0).getId());
        assertEquals(professional.getUser_name(), sut.get(0).getUser_name());
    }

    @Test
    public void professionals_adding_serveral_professionals_returns_all_professionals() throws Exception
    {
        Professionals sut = new Professionals();

        for (int i = 0; i < 10; i++)
        {
            Category category = Category.of(i, "My category " + i, true);
            Professional professional = Professional.of(String.valueOf(i), "My category " + i, "Barman Antonio", category, "logo", 1.0, 1, 1, 1.0);

            sut.add(professional);
        }

        assertEquals(10, sut.size());
        assertEquals(10, sut.allProfessionals().size());
        assertEquals("0", sut.allProfessionals().get(0).getId());
        assertEquals("My category 0", sut.allProfessionals().get(0).getUser_name());
    }
}































