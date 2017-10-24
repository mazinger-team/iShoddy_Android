package com.mazinger.ishoddy.domain.managers.entities.Professional;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProfessionalsOutputType
{
    @SerializedName("professionals")
    @Expose
    private List<ProfessionalsEntity> mProfessionalsEntity;

    public List<ProfessionalsEntity> getProfessionalsEntity() {
        return mProfessionalsEntity;
    }

    public void setProfessionalsEntity(List<ProfessionalsEntity> professionalsEntity) {
        this.mProfessionalsEntity = professionalsEntity;
    }
}
