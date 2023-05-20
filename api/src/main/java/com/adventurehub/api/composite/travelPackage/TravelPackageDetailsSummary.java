package com.adventurehub.api.composite.travelPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class TravelPackageDetailsSummary {
    private Integer travelPackageDetailsId;
    private String imageUrl;

    public TravelPackageDetailsSummary(Integer travelPackageDetailsId, String imageUrl) {
        this.travelPackageDetailsId = travelPackageDetailsId;
        this.imageUrl = imageUrl;
    }

    public Integer getTravelPackageDetailsId() {
        return travelPackageDetailsId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
