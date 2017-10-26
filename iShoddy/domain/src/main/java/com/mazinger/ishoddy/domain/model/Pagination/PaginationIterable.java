package com.mazinger.ishoddy.domain.model.Pagination;

public interface PaginationIterable {
    long size();
    Pagination get(long index);
    Pagination allPagination();
}
