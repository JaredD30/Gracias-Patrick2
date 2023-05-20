package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.TravelPackageDetailsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetails;

@Mapper(componentModel = "spring")
public interface TravelPackageDetailsMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "travelPackageDetailsId", ignore = true),
    })
    TravelPackageDetails entityToApi(TravelPackageDetailsEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    TravelPackageDetailsEntity apiToEntity(TravelPackageDetails api);
}

