package com.adventurehub.microservices.core.travelpackage.services;

import com.adventurehub.microservices.core.travelpackage.entity.ItineraryEntity;
import com.adventurehub.microservices.core.travelpackage.mapper.ItineraryMapper;
import com.adventurehub.microservices.core.travelpackage.repository.ItineraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.itinerary.Itinerary;
import com.adventurehub.api.core.itinerary.ItineraryService;
import com.adventurehub.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItineraryServiceImpl implements ItineraryService {

    private static final Logger LOG = LoggerFactory.getLogger(ItineraryServiceImpl.class);

    private final ServiceUtil serviceUtil;

    private final ItineraryRepository repository;

    private final ItineraryMapper mapper;

    @Autowired
    public ItineraryServiceImpl(ServiceUtil serviceUtil, ItineraryRepository repository, ItineraryMapper mapper) {
        this.serviceUtil = serviceUtil;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Itinerary> getItineraries(Integer travelPackageId) {

        List<Itinerary> list = new ArrayList<>();

        if (travelPackageId < 1) throw new IllegalArgumentException("Invalid travelPackageId: " + travelPackageId);

        Iterable<ItineraryEntity> entityList = repository.findByTravelPackageId(travelPackageId);
        entityList.forEach(e -> {
            Itinerary response = mapper.entityToApi(e);
            response.setItineraryId(e.getId());
            response.setServiceAddress(serviceUtil.getServiceAddress());
            list.add(response);
        });

        LOG.debug("/itinerary response size: {}", list.size());
        return list;
    }

    @Override
    public Itinerary createItinerary(Itinerary body){

        ItineraryEntity entity = mapper.apiToEntity(body);
        ItineraryEntity newEntity = repository.save(entity);

        LOG.debug("createItinerary: entity created for travelPackageDetailsId", newEntity.getId() );

        Itinerary activity = mapper.entityToApi(newEntity);
        activity.setItineraryId(newEntity.getId());

        return activity;
    }
}