package com.mazinger.ishoddy.domain.managers.entities.common;

import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class HeaderData
{
    private PaginationDataEntity pagination;

    public PaginationDataEntity getPaginationData() { return this.pagination; }

    public void setPaginationData(PaginationDataEntity paginationData) { this.pagination = paginationData; }

    private ErrorData errorData;

    public ErrorData getErrorData() { return this.errorData; }

    public void setErrorData(ErrorData errorData) { this.errorData = errorData; }
}
