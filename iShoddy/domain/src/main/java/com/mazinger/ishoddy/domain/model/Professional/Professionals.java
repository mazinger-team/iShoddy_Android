package com.mazinger.ishoddy.domain.model.Professional;

import android.support.annotation.NonNull;

import java.util.LinkedList;
import java.util.List;

public class Professionals implements ProfessionalsIterable, ProfessionalsUpdatable
{
    private List<Professional> professionals;

    public static Professionals from(@NonNull final List<Professional> professionalList)
    {
        final Professionals professionals = new Professionals();

        for (final Professional professional : professionalList)
        {
            professionals.add(professional);
        }

        return professionals;
    }

    public Professionals()
    {

    }

    // lazy getter
    private List<Professional> getProfessionals()
    {
        if (professionals == null)
        {
            professionals = new LinkedList<>();
        }

        return  professionals;
    }

    @Override
    public void add(Professional professional)
    {
        getProfessionals().add(professional);
    }

    @Override
    public void delete(Professional professional)
    {
        getProfessionals().remove(professional);
    }

    @Override
    public void update(Professional newProfessional, long index)
    {
        getProfessionals().set((int)index, newProfessional);
    }

    @Override
    public long size()
    {
        return getProfessionals().size();
    }

    @Override
    public Professional get(long index)
    {
        return getProfessionals().get((int)index);
    }

    @Override
    public List<Professional> allProfessionals()
    {
        List<Professional> listCopy = new LinkedList<>();

        for (Professional professional : getProfessionals()) {

            listCopy.add(professional);
        }

        return listCopy;
    }
}






























