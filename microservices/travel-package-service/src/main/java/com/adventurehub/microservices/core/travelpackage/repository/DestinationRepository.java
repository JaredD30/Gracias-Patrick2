package com.adventurehub.microservices.core.travelpackage.repository;

import com.adventurehub.microservices.core.travelpackage.entity.DestinationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinationRepository extends JpaRepository<DestinationEntity, Integer> {
    DestinationEntity findByName(String name);
    boolean existsByName(String name);
}
