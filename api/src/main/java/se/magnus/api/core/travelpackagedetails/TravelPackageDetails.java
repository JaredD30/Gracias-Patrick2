package se.magnus.api.core.travelpackagedetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class TravelPackageDetails {
    private Integer travelPackageId;
    private String image;
    private String serviceAddress;

    public TravelPackageDetails(Integer travelPackageId, String image, String serviceAddress) {
        this.travelPackageId = travelPackageId;
        this.image = image;
        this.serviceAddress = serviceAddress;
    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public String getImage() {
        return image;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }
}
