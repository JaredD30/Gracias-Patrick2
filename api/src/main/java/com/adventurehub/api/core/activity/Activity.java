package com.adventurehub.api.core.activity;

public class Activity {
    private Integer activityId;
    private Integer itineraryId;
    private String name;
    private String serviceAddress;

    public Activity() {
    }

    public Activity(Integer activityId, Integer itineraryId, String name, String serviceAddress) {
        this.activityId = activityId;
        this.itineraryId = itineraryId;
        this.name = name;
        this.serviceAddress = serviceAddress;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getItineraryId() {
        return itineraryId;
    }

    public void setItineraryId(Integer itineraryId) {
        this.itineraryId = itineraryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
