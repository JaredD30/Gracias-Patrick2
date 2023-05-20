package com.adventurehub.api.composite.travelPackage;

import lombok.*;

import java.util.Date;

public class ItinerarySummary {
    private Integer itineraryId;
    private Date startDate;
    private Date endDate;
    private Double latitude;
    private Double longitude;

    public ItinerarySummary(Integer itineraryId, Date startDate, Date endDate, Double latitude, Double longitude) {
        this.itineraryId = itineraryId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getItineraryId() {
        return itineraryId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
}
