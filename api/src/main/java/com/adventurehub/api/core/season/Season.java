package com.adventurehub.api.core.season;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class Season {
    private Integer seasonId;
    private String name;
    private String serviceAddress;
    public Integer getSeasonId() {
        return seasonId;
    }
    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
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
