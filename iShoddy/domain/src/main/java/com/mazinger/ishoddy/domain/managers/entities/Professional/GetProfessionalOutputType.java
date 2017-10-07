package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetProfessionalOutputType
{
    @SerializedName("professional")
    @Expose
    private Professional professional;

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
