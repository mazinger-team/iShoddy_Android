package com.mazinger.ishoddy.domain.model.Pagination;

import android.support.annotation.NonNull;

import com.mazinger.ishoddy.domain.model.Category;

public class Pagination
{
    private Boolean paginationFlag;
    private Integer paginationKey;
    private Integer paginationElements;

    public static Pagination of(Boolean paginationFlag, Integer paginationKey, Integer paginationElements) {

        Pagination pagination = new Pagination(paginationFlag, paginationKey, paginationElements);

        pagination.setPaginationFlag(paginationFlag);
        pagination.setPaginationKey(paginationKey);
        pagination.setPaginationElements(paginationElements);

        return pagination;
    }

    private Pagination(Boolean paginationFlag, Integer paginationKey, Integer paginationElements) {
        this.paginationFlag = paginationFlag;
        this.paginationKey = paginationKey;
        this.paginationElements = paginationElements;
    }

    public Pagination(Boolean paginationFlag) {
        this.paginationFlag = paginationFlag;
    }

    public Boolean getPaginationFlag() {
        return paginationFlag;
    }

    public Pagination setPaginationFlag(Boolean paginationFlag) {
        this.paginationFlag = paginationFlag;
        return this;
    }

    public Integer getPaginationKey() {
        return paginationKey;
    }

    public Pagination setPaginationKey(Integer paginationKey) {
        this.paginationKey = paginationKey;
        return this;
    }

    public Integer getPaginationElements() {
        return paginationElements;
    }

    public Pagination setPaginationElements(Integer paginationElements) {
        this.paginationElements = paginationElements;
        return this;
    }
}