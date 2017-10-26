package com.mazinger.ishoddy.domain.managers.jsonparser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsResponseType;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;

public class ProfessionalsJsonParser
{
    public List<ProfessionalsEntity> parser(String response)
    {
        List<ProfessionalsEntity> professionalsEntities = null;

        try {
            Gson gson = new GsonBuilder().create();

            Reader reader = new StringReader(response);
            ProfessionalsResponseType professionalsResponseType = gson.fromJson(reader, ProfessionalsResponseType.class);
            professionalsEntities = professionalsResponseType.getProfessionalsOutputType().getProfessionalsEntity();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return professionalsEntities;
    }
}
