package com.mazinger.ishoddy.domain.managers.entities.common;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class Pagination
{
    private boolean paginationFlag;

    public boolean getPaginationFlag() {
        return this.paginationFlag;
    }

    public void setPaginationFlag(boolean paginationFlag) {
        this.paginationFlag = paginationFlag;
    }

    private String paginationKey;

    public String getPaginationKey() {
        return this.paginationKey;
    }

    public void setPaginationKey(String paginationKey) {
        this.paginationKey = paginationKey;
    }
}
