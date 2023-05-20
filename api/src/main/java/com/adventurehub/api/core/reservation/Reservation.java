package com.adventurehub.api.core.reservation;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class Reservation {
    private Integer travelPackageId;
    private Integer reservationId;
    private int numPeople;
    private BigDecimal totalPrice;
    private String serviceAddress;

    public Reservation(Integer travelPackageId, Integer reservationId,int numPeople, BigDecimal totalPrice, String serviceAddress) {
        this.travelPackageId = travelPackageId;
        this.reservationId = reservationId;
        this.numPeople = numPeople;
        this.totalPrice = totalPrice;
        this.serviceAddress = serviceAddress;
    }
}
