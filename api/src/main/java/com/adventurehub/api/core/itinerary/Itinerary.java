package com.adventurehub.api.core.itinerary;

import java.util.Date;

public class Itinerary {
    private Integer itineraryId;
    private Integer travelPackageId;
    private Date startDate;
    private Date endDate;
    private Double latitude;
    private Double longitude;
    private String serviceAddress;

    public Itinerary() {
    }

    public Itinerary(Integer itineraryId, Integer travelPackageId, Date startDate, Date endDate, Double latitude, Double longitude, String serviceAddress) {
        this.itineraryId = itineraryId;
        this.travelPackageId = travelPackageId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.serviceAddress = serviceAddress;
    }

    public Integer getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Integer itineraryId) {
        this.itineraryId = itineraryId;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Integer travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
