package com.mazinger.ishoddy.domain.interactors.cache.Professionals;

public interface GetIfAllProfessionalsAreCachedInteractor
{
    void execute(Runnable onAllProfessionalsAreCached, Runnable onAllProfessionalsAreNotCached);
}
