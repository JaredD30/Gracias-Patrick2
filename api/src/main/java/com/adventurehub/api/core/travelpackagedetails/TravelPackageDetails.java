package com.adventurehub.api.core.travelpackagedetails;

public class TravelPackageDetails {
    private Integer travelPackageDetailsId;
    private Integer travelPackageId;
    private String image;
    private String serviceAddress;

    public TravelPackageDetails() {
        this.travelPackageDetailsId = 0;
        this.travelPackageId = 0;
        this.image = null;
        this.serviceAddress = null;
    }

    public TravelPackageDetails(Integer travelPackageDetailsId, Integer travelPackageId, String image, String serviceAddress) {
        this.travelPackageDetailsId = travelPackageDetailsId;
        this.travelPackageId = travelPackageId;
        this.image = image;
        this.serviceAddress = serviceAddress;
    }

    public Integer getTravelPackageDetailsId() {
        return travelPackageDetailsId;
    }

    public void setTravelPackageDetailsId(Integer travelPackageDetailsId) {
        this.travelPackageDetailsId = travelPackageDetailsId;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Integer travelPackageId) {
        this.travelPackageId = travelPackageId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
