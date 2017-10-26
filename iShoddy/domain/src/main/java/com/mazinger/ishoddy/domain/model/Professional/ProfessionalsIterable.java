package com.mazinger.ishoddy.domain.model.Professional;

import java.util.List;

public interface ProfessionalsIterable
{
    long size();
    Professional get(long index);
    List<Professional> allProfessionals();
}
