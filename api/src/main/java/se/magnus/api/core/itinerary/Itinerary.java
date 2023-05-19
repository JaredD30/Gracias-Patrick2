package se.magnus.api.core.itinerary;

import lombok.*;
import java.util.Date;

public class Itinerary {
    private Integer itineraryId;
    private Integer travelPackageId;
    private Date startDate;
    private Date endDate;
    private String origin;
    private String destination;
    private Double latitude;
    private Double longitude;
    private String serviceAddress;

    public Itinerary(Integer itineraryId, Integer travelPackageId, Date startDate, Date endDate, String origin, String destination, Double latitude, Double longitude, String serviceAddress) {
        this.itineraryId = itineraryId;
        this.travelPackageId = travelPackageId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.origin = origin;
        this.destination = destination;
        this.latitude = latitude;
        this.longitude = longitude;
        this.serviceAddress = serviceAddress;
    }

    public Integer getItineraryId() {
        return itineraryId;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
