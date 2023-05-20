package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.SeasonEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.SeasonMapper;
import com.adventurehub.microservices.core.travelpackage.repository.SeasonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.season.Season;
import com.adventurehub.api.core.season.SeasonService;
import com.adventurehub.util.http.ServiceUtil;

import java.util.Optional;

@RestController
public class SeasonServiceImpl implements SeasonService {
    private static final Logger LOG = LoggerFactory.getLogger(SeasonServiceImpl.class);

    private final ServiceUtil serviceUtil;
    private final SeasonRepository repository;
    private final SeasonMapper mapper;

    @Autowired
    public SeasonServiceImpl(SeasonRepository seasonRepository, SeasonMapper mapper,ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
        this.mapper = mapper;
        this.repository = seasonRepository;
    }

    @Override
    public Season getSeason(Integer seasonId) {
        LOG.debug("/season return the found for seasonId={}", seasonId);

        Optional<SeasonEntity> entitySeason = repository.findById(seasonId);

        if(entitySeason.isPresent()){
            Season response = mapper.entityToApi(entitySeason.get());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            response.setSeasonId(entitySeason.get().getId());
            return response;
        }

        return null;
    }

//    @Override
//    public Season createSeason(Season body) {
//        return null;
//    }
}