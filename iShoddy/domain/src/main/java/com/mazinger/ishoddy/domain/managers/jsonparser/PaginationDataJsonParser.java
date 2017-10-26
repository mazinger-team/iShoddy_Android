package com.mazinger.ishoddy.domain.managers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.CategoriesResponseEntity;
import com.mazinger.ishoddy.domain.managers.entities.CategoryEntity;
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsResponseType;
import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataEntity;
import com.mazinger.ishoddy.domain.managers.entities.common.PaginationData.PaginationDataResponseEntity;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class PaginationDataJsonParser
{
    public PaginationDataEntity parser(String response)
    {
        PaginationDataEntity paginationDataEntities = null;

        try {
            Gson gson = new GsonBuilder().create();

            Reader reader = new StringReader(response);
            PaginationDataResponseEntity paginationDataResponseEntity = gson.fromJson(reader, PaginationDataResponseEntity.class);
            paginationDataEntities = paginationDataResponseEntity.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return paginationDataEntities;
    }
}
