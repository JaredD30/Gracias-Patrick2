package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.TravelPackageEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import se.magnus.api.core.travelpackage.TravelPackage;

@Mapper(componentModel = "spring")
public interface TravelPackageMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true)
    })
    TravelPackage entityToApi(TravelPackageEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    TravelPackageEntity apiToEntity(TravelPackage api);
}

