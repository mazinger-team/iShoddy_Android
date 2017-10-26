package com.mazinger.ishoddy.domain.managers.entities.common.PaginationData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PaginationDataResponseEntity {
    @SerializedName("headerData") private Result result;

    public PaginationDataEntity getResult() {
        return this.result.getPaginationData();
    }

    public class Result {
        @SerializedName("paginationData") private PaginationDataEntity paginationData;

        public PaginationDataEntity getPaginationData() {
            return paginationData;
        }
    }
}
