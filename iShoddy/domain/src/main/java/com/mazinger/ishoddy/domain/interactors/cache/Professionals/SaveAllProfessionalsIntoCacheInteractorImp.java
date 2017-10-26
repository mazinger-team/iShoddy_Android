package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

import com.mazinger.ishoddy.domain.model.Professional.Professionals;

public class SaveAllProfessionalsIntoCacheInteractorImp implements SaveAllProfessionalsIntoCacheInteractor
{
    private SaveAllProfessionalsIntoCacheManager manager;

    public SaveAllProfessionalsIntoCacheInteractorImp(SaveAllProfessionalsIntoCacheManager manager)
    {
        this.manager = manager;
    }

    @Override
    public void execute(Professionals professionals, Runnable completion)
    {
        manager.execute(professionals, completion);
    }
}
