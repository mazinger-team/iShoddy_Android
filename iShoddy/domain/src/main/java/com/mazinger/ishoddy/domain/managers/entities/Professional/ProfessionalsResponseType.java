package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.common.HeaderData;





public class ProfessionalsResponseType {
    @SerializedName("headerData")
    private HeaderData headerData;

    @SerializedName("listProfessionalsOutputType")
    private ProfessionalsOutputType mProfessionalsOutputType;

    public HeaderData getHeaderData() {
        return this.headerData;
    }

    public void setHeaderData(HeaderData headerData) {
        this.headerData = headerData;
    }

    public ProfessionalsOutputType getProfessionalsOutputType() {
        return this.mProfessionalsOutputType;
    }

    public void setProfessionalsOutputType(ProfessionalsOutputType professionalsOutputType) {
        this.mProfessionalsOutputType = professionalsOutputType;
    }
}
