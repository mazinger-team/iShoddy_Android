package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.common.HeaderData;

public class GetProfessionalResponseType {
    @SerializedName("headerData")
    private HeaderData headerData;

    @SerializedName("listProfessionalsOutputType")
    private GetProfessionalOutputType getProfessionalOutputType;

    public HeaderData getHeaderData() {
        return this.headerData;
    }

    public void setHeaderData(HeaderData headerData) {
        this.headerData = headerData;
    }

    public GetProfessionalOutputType getGetProfessionalOutputType() {
        return this.getProfessionalOutputType;
    }

    public void setGetProfessionalOutputType(GetProfessionalOutputType getProfessionalOutputType) {
        this.getProfessionalOutputType = getProfessionalOutputType;
    }
}
