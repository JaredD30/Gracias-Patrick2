package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.DestinationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.destination.Destination;

@Mapper(componentModel = "spring")
public interface DestinationMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "destinationId", ignore = true)
    })
    Destination entityToApi(DestinationEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    DestinationEntity apiToEntity(Destination api);
}

