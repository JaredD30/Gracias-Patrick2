package com.adventurehub.api.core.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {
    private Integer userId;
    private Integer reservationId;
    private Integer paymentId;
    private Double amount;
    private Date paymentDate;
    private String paymentMethod;
    private String serviceAddress;
}
