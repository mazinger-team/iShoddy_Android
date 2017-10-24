package com.mazinger.ishoddy.domain.model.Pagination;

public interface PaginationUpdatable
{
    void add(Pagination pagination);
    void delete(Pagination pagination);
    void update(Pagination newPagination, long index);
}
