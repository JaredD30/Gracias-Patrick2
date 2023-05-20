package com.adventurehub.api.core.destination;

public class Destination {
    private Integer destinationId;
    private String name;
    private String description;
    private String serviceAddress;

    public Destination(){}

    public Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
