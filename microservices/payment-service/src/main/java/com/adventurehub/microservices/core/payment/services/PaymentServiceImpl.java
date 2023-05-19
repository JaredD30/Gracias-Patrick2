package com.adventurehub.microservices.core.payment.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import se.magnus.api.core.payment.PaymentService;
import se.magnus.api.core.payment.Payment;
import se.magnus.util.exceptions.InvalidInputException;
import se.magnus.util.exceptions.NotFoundException;
import se.magnus.util.http.ServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public PaymentServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Payment> getPayments(Integer userId) {
        LOG.debug("/payment return the found payment for userId={}", userId);

        if (userId < 1) throw new InvalidInputException("Invalid userId: " + userId);

        if (userId == 13) throw new NotFoundException("No product found for userId: " + userId);

        List<Payment> list = new ArrayList<>();
        list.add(new Payment(userId, 1, 1, 12.0, new Date(), "Credit Card", serviceUtil.getServiceAddress()));
        list.add(new Payment(userId, 2, 2, 20.0, new Date(), "Credit Card", serviceUtil.getServiceAddress()));
        list.add(new Payment(userId, 3, 3, 30.0, new Date(), "Credit Card", serviceUtil.getServiceAddress()));

        LOG.debug("/recommendation response size: {}", list.size());

        return list;
    }
}