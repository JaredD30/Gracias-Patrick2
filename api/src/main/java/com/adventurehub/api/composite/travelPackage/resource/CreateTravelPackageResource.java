package com.adventurehub.api.composite.travelPackage.resource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateTravelPackageResource {
    private Date startDate;

    private Date endDate;

    private String status = "A";

    private String name;

    private String description;

    private BigDecimal price;

    private String groupSize;

    private Integer seasonId;

    private Integer categoryId;

    private Integer destinationId;

    private Set<String> images = new HashSet<>();
    private Set<CreateItineraryResource> itineraries = new HashSet<>();

    public CreateTravelPackageResource() {
    }

    public CreateTravelPackageResource(Date startDate, Date endDate, String status, String name, String description, BigDecimal price, String groupSize, Integer seasonId, Integer categoryId, Integer destinationId, Set<String> images, Set<CreateItineraryResource> itineraries) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.name = name;
        this.description = description;
        this.price = price;
        this.groupSize = groupSize;
        this.seasonId = seasonId;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
        this.images = images;
        this.itineraries = itineraries;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(String groupSize) {
        this.groupSize = groupSize;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    public Set<CreateItineraryResource> getItineraries() {
        return itineraries;
    }

    public void setItineraries(Set<CreateItineraryResource> itineraries) {
        this.itineraries = itineraries;
    }
}