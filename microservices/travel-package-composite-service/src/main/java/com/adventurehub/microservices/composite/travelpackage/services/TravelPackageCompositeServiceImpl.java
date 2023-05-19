package com.adventurehub.microservices.composite.travelpackage.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.composite.travelPackage.*;
import se.magnus.api.core.category.Category;
import se.magnus.api.core.destination.Destination;
import se.magnus.api.core.itinerary.Itinerary;
import se.magnus.api.core.season.Season;
import se.magnus.api.core.travelpackage.TravelPackage;
import se.magnus.api.core.travelpackagedetails.TravelPackageDetails;
import se.magnus.util.http.ServiceUtil;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TravelPackageCompositeServiceImpl implements TravelPackageCompositeService {

    private static final Logger LOG = LoggerFactory.getLogger(TravelPackageCompositeServiceImpl.class);

    private final ServiceUtil serviceUtil;
    private  TravelPackageCompositeIntegration integration;

    @Autowired
    public TravelPackageCompositeServiceImpl(ServiceUtil serviceUtil, TravelPackageCompositeIntegration integration) {
        this.serviceUtil = serviceUtil;
        this.integration = integration;
    }

    @Override
    public void createCompositeTravelPackage(TravelPackageAggregate body) {
            try {
                TravelPackage travelPackage = new TravelPackage(
                        null,
                        body.getCategory().getCategoryId(),
                        body.getDestination().getDestinationId(),
                        body.getSeason().getSeasonId(),
                        body.getName(),
                        body.getDescription(),
                        body.getPrice(),
                        body.getStartDate(),
                        body.getEndDate(),
                        body.getGroupSize(),
                        body.getStatus(),
                        serviceUtil.getServiceAddress());

                TravelPackage createdTravelPackage = integration.createTravelPackage(travelPackage);
                LOG.debug("createCompositeTravelPackage: creates a new composite entity for travelPackageId: {}", createdTravelPackage.getTravelPackageId());

//                if (body.getItineraries() != null) {
//                    body.getItineraries().forEach(itinerary -> {
//                        Itinerary itinerary1 = new Itinerary(
//                                itinerary.getItineraryId(),
//                                itinerary.getTravelPackageId(),
//                                itinerary.getItineraryName(),
//                                itinerary.getItineraryDescription(),
//                                itinerary.getItineraryDate(),
//                                itinerary.getItineraryTime(),
//                                itinerary.getItineraryLocation(),
//                                itinerary.getItineraryPrice()
//                        );
//                        integration.createItinerary(itinerary1);
//                    });
//                }

                LOG.debug("createCompositeTravelPackage: composite entites created for travelPackageId: {}",createdTravelPackage.getTravelPackageId());

            } catch (RuntimeException re) {
                throw re;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    @Override
    public List<TravelPackageAggregate> getCompositeTravelPackages() {
        List<TravelPackage> travelPackages = integration.getTravelPackages();

        LOG.debug("/travelPackage-composite getTravelPackages found: {}", travelPackages.size());

        return travelPackages.stream()
                .map(tp -> createTravelPackageAggregate(tp, serviceUtil.getServiceAddress()))
                .collect(Collectors.toList());
    }

    private TravelPackageAggregate createTravelPackageAggregate(TravelPackage travelPackage, String serviceAddress) {

        // 1. Setup travel package info
        Integer travelPackageId = travelPackage.getTravelPackageId();
        String name = travelPackage.getName();
        String description = travelPackage.getDescription();
        BigDecimal price = travelPackage.getPrice();
        Date startDate = travelPackage.getStartDate();
        Date endDate = travelPackage.getEndDate();
        String groupSize = travelPackage.getGroupSize();
        String status = travelPackage.getStatus();

        Destination destination = integration.getDestination(travelPackage.getDestinationId());
        Category category = integration.getCategory(travelPackage.getCategoryId());
        Season season = integration.getSeason(travelPackage.getSeasonId());

        List<Itinerary> itineraries = integration.getItineraries(travelPackageId);
        List<TravelPackageDetails> travelPackageDetails = integration.getTravelPackageDetails(travelPackageId);

        // 2. Copy summary info, if available
        List<ItinerarySummary> itinerariesSummary = (itineraries == null) ? null :
                itineraries.stream()
                        .map(i -> new ItinerarySummary(i.getItineraryId(), i.getStartDate(), i.getEndDate(),i.getOrigin(),i.getDestination(),i.getLatitude(),i.getLongitude()))
                        .collect(Collectors.toList());
        List<TravelPackageDetailsSummary> travelPackageDetailsSummary = (travelPackageDetails == null) ? null :
                travelPackageDetails.stream()
                        .map(tpd -> new TravelPackageDetailsSummary(tpd.getTravelPackageId(), tpd.getImage()))
                        .collect(Collectors.toList());

        DestinationSummary destinationSummary = (destination == null) ? null :
                new DestinationSummary(destination.getDestinationId(), destination.getName(), destination.getDescription());

        CategorySummary categorySummary = (category == null) ? null :
                new CategorySummary(category.getCategoryId(), category.getName());

        SeasonSummary seasonSummary = (season == null) ? null :
                new SeasonSummary(season.getSeasonId(), season.getName());

        // 3. Create info regarding the involved microservices addresses
        String travelPackageAddress = travelPackage.getServiceAddress();
        ServiceAddresses serviceAddresses = new ServiceAddresses(serviceAddress, travelPackageAddress);

        return new TravelPackageAggregate(
                travelPackageId,
                categorySummary,
                destinationSummary,
                seasonSummary,
                name,
                description,
                price,
                startDate,
                endDate,
                groupSize,
                status,
                travelPackageAddress,
                itinerariesSummary,
                travelPackageDetailsSummary,
                serviceAddresses
        );

    }
}