package com.adventurehub.api.composite.travelPackage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TravelPackageAggregate {
    private final Integer travelPackageId;
    private final CategorySummary category;
    private final DestinationSummary destination;
    private final SeasonSummary season;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final Date startDate;
    private final Date endDate;
    private final String groupSize;
    private final String status;
    private final String serviceAddress;
    private final List<ItinerarySummary> itineraries;
    private final List<TravelPackageDetailsSummary> travelPackageDetails;
    private final ServiceAddresses serviceAddresses;

    public TravelPackageAggregate() {
        travelPackageId = 0;
        category = null;
        destination = null;
        season = null;
        name = null;
        description = null;
        price = null;
        startDate = null;
        endDate = null;
        groupSize = null;
        status = null;
        serviceAddress = null;
        itineraries = null;
        travelPackageDetails = null;
        serviceAddresses = null;
    }

    public TravelPackageAggregate(Integer travelPackageId, CategorySummary category, DestinationSummary destination, SeasonSummary season, String name, String description, BigDecimal price, Date startDate, Date endDate, String groupSize, String status, String serviceAddress, List<ItinerarySummary> itineraries, List<TravelPackageDetailsSummary> travelPackageDetails, ServiceAddresses serviceAddresses) {
        this.travelPackageId = travelPackageId;
        this.category = category;
        this.destination = destination;
        this.season = season;
        this.name = name;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupSize = groupSize;
        this.status = status;
        this.serviceAddress = serviceAddress;
        this.itineraries = itineraries;
        this.travelPackageDetails = travelPackageDetails;
        this.serviceAddresses = serviceAddresses;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public CategorySummary getCategory() {
        return category;
    }

    public DestinationSummary getDestination() {
        return destination;
    }

    public SeasonSummary getSeason() {
        return season;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getGroupSize() {
        return groupSize;
    }

    public String getStatus() {
        return status;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public List<ItinerarySummary> getItineraries() {
        return itineraries;
    }

    public List<TravelPackageDetailsSummary> getTravelPackageDetails() {
        return travelPackageDetails;
    }

    public ServiceAddresses getServiceAddresses() {
        return serviceAddresses;
    }
}