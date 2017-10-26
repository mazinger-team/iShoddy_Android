
package com.mazinger.ishoddy.domain.managers.entities.common.PaginationData;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaginationDataEntity {

    @SerializedName("paginationFlag") @Expose private Boolean paginationFlag;
    @SerializedName("paginationKey") @Expose private Integer paginationKey;
    @SerializedName("paginationElements") @Expose private Integer paginationElements;

    public Boolean getPaginationFlag() {
        return paginationFlag;
    }

    public Integer getPaginationKey() {
        return paginationKey;
    }

    public Integer getPaginationElements() {
        return paginationElements;
    }
}
