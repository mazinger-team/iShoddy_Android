package com.mazinger.ishoddy.domain.managers.network.Pagination;

import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;
import com.mazinger.ishoddy.domain.model.Pagination.Pagination;

public class PaginationEntityIntoPaginationMapper {
    public static Pagination getPagination(PaginationDataEntity mPaginationDataEntity) {
        /*
        Pagination pagination = new Pagination(mPaginationDataEntity.getPaginationKey())
                .setPaginationFlag(mPaginationDataEntity.getPaginationFlag())
                .setPaginationElements(mPaginationDataEntity.getPaginationElements());
*/
        Pagination pagination = Pagination.of(mPaginationDataEntity.getPaginationFlag(), mPaginationDataEntity.getPaginationKey(), mPaginationDataEntity.getPaginationElements());

        return pagination;
    }
}
