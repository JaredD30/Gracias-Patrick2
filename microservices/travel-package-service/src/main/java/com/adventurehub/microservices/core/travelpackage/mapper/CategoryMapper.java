package com.adventurehub.microservices.core.travelpackage.mapper;

import com.adventurehub.microservices.core.travelpackage.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.adventurehub.api.core.category.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(target = "serviceAddress", ignore = true),
            @Mapping(target = "categoryId", ignore = true)
    })
    Category entityToApi(CategoryEntity entity);

    @Mappings({
            @Mapping(target = "id", ignore = true),
    })
    CategoryEntity apiToEntity(Category api);
}

