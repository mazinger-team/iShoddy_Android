package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

public interface SetAllProfessionalAreCachedInteractor
{
    public static final String PROFESSIONALS_SAVED = "PROFESSIONALS_SAVED";

    void execute(boolean professionalSaved);
}
