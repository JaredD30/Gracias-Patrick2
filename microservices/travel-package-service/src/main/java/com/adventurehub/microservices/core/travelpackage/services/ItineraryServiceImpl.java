package com.adventurehub.microservices.core.travelpackage.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.itinerary.Itinerary;
import se.magnus.api.core.itinerary.ItineraryService;
import se.magnus.api.core.travelpackage.TravelPackage;
import se.magnus.api.core.travelpackage.TravelPackageService;
import se.magnus.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ItineraryServiceImpl implements ItineraryService {

    private static final Logger LOG = LoggerFactory.getLogger(ItineraryServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ItineraryServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Itinerary> getItineraries(Integer travelPackageId) {

        List<Itinerary> list = new ArrayList<>();

        if (travelPackageId < 1) throw new IllegalArgumentException("Invalid travelPackageId: " + travelPackageId);

//        list.add(new Itinerary(1, travelPackageId, new Date(),new Date(), "Origin 1", "Destination 1", 1.0, 1.0, serviceUtil.getServiceAddress()));
//        list.add(new Itinerary(2, travelPackageId, new Date(),new Date(), "Origin 1", "Destination 1", 1.0, 1.0, serviceUtil.getServiceAddress()));

        LOG.debug("/itinerary response size: {}", list.size());

        return list;
    }
}