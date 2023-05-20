package com.adventurehub.api.core.payment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PaymentService {

    /**
     * Sample usage: curl $HOST:$PORT/payment?userId=1
     *
     * @param userId
     * @return the payment, if found, else null
     */
    @GetMapping(
            value    = "/payment/{userId}",
            produces = "application/json")
    List<Payment> getPayments(@RequestParam(value = "userId", required = true) Integer userId);
}
