package com.mazinger.ishoddy.domain.managers.entities.common;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class HeaderData
{
    private Pagination pagination;

    public Pagination getPagination() { return this.pagination; }

    public void setPagination(Pagination pagination) { this.pagination = pagination; }

    private ErrorData errorData;

    public ErrorData getErrorData() { return this.errorData; }

    public void setErrorData(ErrorData errorData) { this.errorData = errorData; }
}
