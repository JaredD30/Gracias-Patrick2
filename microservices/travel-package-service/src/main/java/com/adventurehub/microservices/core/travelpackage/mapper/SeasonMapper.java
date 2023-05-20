package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.SeasonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.season.Season;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "seasonId",ignore = true)
    })
    Season entityToApi(SeasonEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    SeasonEntity apiToEntity(Season api);
}

