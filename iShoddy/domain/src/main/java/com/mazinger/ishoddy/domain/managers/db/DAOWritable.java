package com.mazinger.ishoddy.domain.managers.db;

import android.support.annotation.NonNull;

public interface DAOWritable<T>
{
    long insert(@NonNull final T element);

    long update(final long id, final T element);

    long delete(final long id);

    long delete(T element);

    void deleteAll();

    long delete(String where, String... whereClause);

    int numRecords();
}
