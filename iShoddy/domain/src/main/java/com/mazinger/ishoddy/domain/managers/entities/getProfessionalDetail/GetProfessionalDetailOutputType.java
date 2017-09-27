package com.mazinger.ishoddy.domain.managers.entities.getProfessionalDetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class GetProfessionalDetailOutputType
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
