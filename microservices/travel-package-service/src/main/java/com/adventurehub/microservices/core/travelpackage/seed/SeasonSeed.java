package com.adventurehub.microservices.core.travelpackage.seed;

import com.adventurehub.microservices.core.travelpackage.entity.SeasonEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.SeasonMapper;
import com.adventurehub.microservices.core.travelpackage.repository.SeasonRepository;
import com.adventurehub.microservices.core.travelpackage.services.SeasonServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.magnus.api.core.season.Season;

import java.util.Arrays;

@Service
public class SeasonSeed {
    private static String[] DEFAULT_SEASON = {"SUMMER", "WINTER", "FALL", "SPRING"};

    private static final Logger LOG = LoggerFactory.getLogger(SeasonServiceImpl.class);

    @Autowired
    private  SeasonRepository repository;
    @Autowired
    private  SeasonMapper mapper;

    public SeasonSeed(SeasonRepository repository, SeasonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void seed() {
        Arrays.stream(DEFAULT_SEASON)
                .forEach(name -> {
                    if(!repository.existsByName(name)) {
                        Season newSeason = new Season();
                        newSeason.setName(name);
                        SeasonEntity seasonEntity = mapper.apiToEntity(newSeason);
                        repository.save(seasonEntity);
                    }
                });
    }
}
