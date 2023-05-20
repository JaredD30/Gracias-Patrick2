package com.adventurehub.api.composite.travelPackage.resource;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateItineraryResource {
    private int day;
    private String location;
    private Date startDate;
    private Date endDate;
    private Double latitude;
    private Double longitude;
    private Set<String> activities = new HashSet<>();

    public CreateItineraryResource() {
    }
    public CreateItineraryResource(int day, String location, Date startDate, Date endDate, Double latitude, Double longitude, Set<String> activities) {
        this.day = day;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.latitude = latitude;
        this.longitude = longitude;
        this.activities = activities;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Set<String> getActivities() {
        return activities;
    }

    public void setActivities(Set<String> activities) {
        this.activities = activities;
    }
}
