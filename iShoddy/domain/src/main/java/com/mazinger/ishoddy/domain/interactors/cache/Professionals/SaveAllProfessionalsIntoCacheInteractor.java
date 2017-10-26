package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

import com.mazinger.ishoddy.domain.model.Professional.Professionals;

public interface SaveAllProfessionalsIntoCacheInteractor
{
    void execute(Professionals professionals, Runnable completion);
}
