package se.magnus.api.core.travelpackage;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

public class TravelPackage {
    private Integer travelPackageId;
    private Integer categoryId;
    private Integer destinationId;
    private Integer seasonId;
    private String name;
    private String description;
    private BigDecimal price;
    private Date startDate;
    private Date endDate;
    private String groupSize;
    private String status;
    private String serviceAddress;

    public TravelPackage(Integer travelPackageId, Integer categoryId, Integer destinationId, Integer seasonId, String name, String description, BigDecimal price, Date startDate, Date endDate, String groupSize, String status, String serviceAddress) {
        this.travelPackageId = travelPackageId;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
        this.seasonId = seasonId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupSize = groupSize;
        this.status = status;
        this.serviceAddress = serviceAddress;
    }

    public TravelPackage() {

    }

    public Integer getTravelPackageId() {
        return travelPackageId;
    }

    public void setTravelPackageId(Integer travelPackageId) {
        this.travelPackageId = travelPackageId;
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

    public String getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(String groupSize) {
        this.groupSize = groupSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
