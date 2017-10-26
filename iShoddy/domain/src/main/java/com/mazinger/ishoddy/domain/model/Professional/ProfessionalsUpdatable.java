package com.mazinger.ishoddy.domain.model.Professional;

public interface ProfessionalsUpdatable
{
    void add(Professional professional);
    void delete(Professional professional);
    void update(Professional newProfessional, long index);
}
