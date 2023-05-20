package com.adventurehub.microservices.core.travelpackage.repository;

import com.adventurehub.microservices.core.travelpackage.entity.ItineraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItineraryRepository extends JpaRepository<ItineraryEntity, Integer> {
    Iterable<ItineraryEntity> findByTravelPackageId(Integer travelPackageId);
}
