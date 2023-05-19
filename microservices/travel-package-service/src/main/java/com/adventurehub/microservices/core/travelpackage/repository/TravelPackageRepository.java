package com.adventurehub.microservices.core.travelpackage.repository;

import com.adventurehub.microservices.core.travelpackage.entity.TravelPackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackageEntity, Integer> {
}

