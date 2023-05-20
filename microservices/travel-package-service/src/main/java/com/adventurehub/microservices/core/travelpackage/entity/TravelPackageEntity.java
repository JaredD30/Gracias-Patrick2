package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "travel_packages")
public class TravelPackageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer categoryId;
    private Integer destinationId;
    private Integer seasonId;
    private String name;
    private String description;
    private BigDecimal price;
    private String groupSize;
    private String status;
    private Date startDate;
    private Date endDate;

    public TravelPackageEntity() {
    }

    public TravelPackageEntity(Integer id, Integer categoryId, Integer destinationId, Integer seasonId, String name, String description, String groupSize, String status, Date startDate, Date endDate) {
        this.id = id;
        this.categoryId = categoryId;
        this.destinationId = destinationId;
        this.seasonId = seasonId;
        this.name = name;
        this.description = description;
        this.groupSize = groupSize;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getGroupSize() {
        return groupSize;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
    }

    public void setSeasonId(Integer seasonId) {
        this.seasonId = seasonId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setGroupSize(String groupSize) {
        this.groupSize = groupSize;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
