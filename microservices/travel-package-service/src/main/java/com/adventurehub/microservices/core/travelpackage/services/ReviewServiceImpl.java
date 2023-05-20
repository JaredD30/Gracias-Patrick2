package com.adventurehub.microservices.core.travelpackage.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.adventurehub.api.core.review.Review;
import com.adventurehub.api.core.review.ReviewService;
import com.adventurehub.util.http.ServiceUtil;

import java.util.List;

@RestController
public class ReviewServiceImpl implements ReviewService {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewServiceImpl.class);

    private final ServiceUtil serviceUtil;

    @Autowired
    public ReviewServiceImpl(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @Override
    public List<Review> getReviews(Integer tripPackageId) {
        LOG.debug("/review return the found activities for tripPackageId={}", tripPackageId);
        return null;
    }

//    @Override
//    public Review createReview(Review body) {
//        return null;
//    }
}