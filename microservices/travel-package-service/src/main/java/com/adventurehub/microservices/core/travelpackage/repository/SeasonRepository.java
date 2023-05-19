package com.adventurehub.microservices.core.travelpackage.repository;

import com.adventurehub.microservices.core.travelpackage.entity.SeasonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonRepository extends JpaRepository<SeasonEntity, Integer>{
    Optional<SeasonEntity> findByName(String name);
    boolean existsByName(String name);

}
