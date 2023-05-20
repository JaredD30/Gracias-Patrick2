package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.ActivityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.activity.Activity;

@Mapper(componentModel = "spring")
public interface ActivityMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "activityId", ignore = true)
    })
    Activity entityToApi(ActivityEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    ActivityEntity apiToEntity(Activity api);
}

