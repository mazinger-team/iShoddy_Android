package com.mazinger.ishoddy.domain.managers.network.Professionals;

import com.mazinger.ishoddy.domain.managers.entities.Professional.ProfessionalsEntity;
import com.mazinger.ishoddy.domain.model.Professional.Professionals;
import com.mazinger.ishoddy.domain.model.Professional.Professional;

import java.util.List;

public class ProfessionalEntityIntoProfessionalsMapper {
    public static Professionals map(List<ProfessionalsEntity> professionalsEntityEntities) {
        Professionals professionals = new Professionals();

        for (ProfessionalsEntity professionalsEntity : professionalsEntityEntities) {
            Professional professional = new Professional(professionalsEntity.getUserName())
                    .setId(professionalsEntity.getId())
                    .setCategory(professionalsEntity.getCategory())
                    .setCorp_name(professionalsEntity.getCorpName())
                    .setLogo_url(professionalsEntity.getLogoUrl())
                    .setRating(professionalsEntity.getRating())
                    .setReviews_number(professionalsEntity.getReviewsNumber())
                    .setPhoto_number(professionalsEntity.getPhotoNumber())
                    .setDistance(professionalsEntity.getDistance());

            professionals.add(professional);
        }

        return professionals;
    }
}
