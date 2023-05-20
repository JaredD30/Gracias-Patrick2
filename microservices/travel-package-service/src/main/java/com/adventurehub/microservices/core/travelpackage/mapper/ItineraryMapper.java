package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.ItineraryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.itinerary.Itinerary;

@Mapper(componentModel = "spring")
public interface ItineraryMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "itineraryId", ignore = true)
    })
    Itinerary entityToApi(ItineraryEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    ItineraryEntity apiToEntity(Itinerary api);
}

