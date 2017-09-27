package com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail;

import com.google.gson.annotations.SerializedName;
import com.mazinger.ishoddy.domain.managers.entities.common.HeaderData;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class GetProfessionalDetailResponseType {
    @SerializedName("headerData")
    private HeaderData headerData;

    @SerializedName("getProfessionalDetailOutputType")
    private GetProfessionalDetailOutputType getProfessionalDetailOutputType;

    public HeaderData getHeaderData() {
        return this.headerData;
    }

    public void setHeaderData(HeaderData headerData) {
        this.headerData = headerData;
    }

    public GetProfessionalDetailOutputType getGetProfessionalDetailOutputType() {
        return this.getProfessionalDetailOutputType;
    }

    public void setGetProfessionalDetailOutputType(GetProfessionalDetailOutputType getProfessionalDetailOutputType) {
        this.getProfessionalDetailOutputType = getProfessionalDetailOutputType;
    }
}
