package com.adventurehub.microservices.composite.travelpackage.services;

import com.adventurehub.api.composite.travelPackage.*;
import com.adventurehub.util.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.composite.travelPackage.resource.CreateTravelPackageResource;
import com.adventurehub.api.core.activity.Activity;
import com.adventurehub.api.core.category.Category;
import com.adventurehub.api.core.destination.Destination;
import com.adventurehub.api.core.itinerary.Itinerary;
import com.adventurehub.api.core.season.Season;
import com.adventurehub.api.core.travelpackage.TravelPackage;
import com.adventurehub.api.core.travelpackagedetails.TravelPackageDetails;
import com.adventurehub.util.http.ServiceUtil;

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
    public void createCompositeTravelPackage(CreateTravelPackageResource body) {
            try {
                TravelPackage travelPackage = new TravelPackage(
                        null,
                        body.getCategoryId(),
                        body.getDestinationId(),
                        body.getSeasonId(),
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

                if(body.getImages() != null) {
                    body.getImages().forEach(url -> {
                        TravelPackageDetails details = new TravelPackageDetails();
                        details.setImage(url);
                        details.setTravelPackageId(createdTravelPackage.getTravelPackageId());
                        integration.createTravelPackageDetails(details);
                    });
                }

                if (body.getItineraries() != null) {
                    body.getItineraries().forEach(i -> {
                        Itinerary itinerary = new Itinerary();
                        itinerary.setTravelPackageId(createdTravelPackage.getTravelPackageId());
                        itinerary.setStartDate(i.getStartDate());
                        itinerary.setEndDate(i.getEndDate());
                        itinerary.setLatitude(i.getLatitude());
                        itinerary.setLongitude(i.getLongitude());
                        Itinerary itinerarySaved = integration.createItinerary(itinerary);

                        for (String iActivity : i.getActivities()) {
                            Activity activity = new Activity();
                            activity.setItineraryId(itinerarySaved.getItineraryId());
                            activity.setName(iActivity);
                            integration.createActivity(activity);
                        }
                    });
                }

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
                .map(tp -> createTravelPackageAggregate(tp, serviceUtil.getServiceAddress(),true))
                .collect(Collectors.toList());
    }

    @Override
    public TravelPackageAggregate getCompositeTravelPackage(Integer travelPackageId) {
        TravelPackage travelPackage = integration.getTravelPackageById(travelPackageId);

        if (travelPackage == null) throw new NotFoundException("No travelPackage found for travelPackageId: " + travelPackageId);

        LOG.debug("/travelPackage-composite getTravelPackage found: {}", travelPackageId);

        return createTravelPackageAggregate(travelPackage, serviceUtil.getServiceAddress(), false);
    }

    private TravelPackageAggregate createTravelPackageAggregate(TravelPackage travelPackage, String serviceAddress, Boolean individual) {

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
                        .map(i -> new ItinerarySummary(i.getItineraryId(), i.getStartDate(), i.getEndDate(),i.getLatitude(),i.getLongitude()))
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
                individual ? null : itinerariesSummary,
                individual ? null : travelPackageDetailsSummary,
                serviceAddresses
        );

    }
}