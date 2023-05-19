package com.adventurehub.microservices.core.travelpackage.repository;

import com.adventurehub.microservices.core.travelpackage.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    boolean existsByName(String categoryName);
}
