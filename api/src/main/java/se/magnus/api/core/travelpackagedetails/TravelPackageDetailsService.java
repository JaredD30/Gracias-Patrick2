package se.magnus.api.core.travelpackagedetails;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TravelPackageDetailsService {

//    @PostMapping(
//            value    = "/travelPackageDetails",
//            produces = "application/json")
//    TravelPackageDetails createTravelPackageDetails(@RequestBody TravelPackageDetails body);

    /**
     * Sample usage: curl $HOST:$PORT/travelPackageDetails?travelPackageId=1
     *
     * @return the destinations found, or null if none found
     */
    @GetMapping(
            value    = "/travelPackageDetails",
            produces = "application/json")
    List<TravelPackageDetails> getTravelPackageDetails(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}
