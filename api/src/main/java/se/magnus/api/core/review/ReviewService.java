package se.magnus.api.core.review;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ReviewService {

    /**
     * Sample usage: curl $HOST:$PORT/review?travelPackageId=1
     *
     * @param travelPackageId
     * @return
     */
    @GetMapping(
            value    = "/review",
            produces = "application/json")
    List<Review> getReviews(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}