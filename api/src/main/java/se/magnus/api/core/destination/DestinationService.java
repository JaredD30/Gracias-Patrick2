package se.magnus.api.core.destination;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface DestinationService {

//    @PostMapping(
//            value    = "/destination",
//            produces = "application/json")
//    Destination createDestination(@RequestBody Destination body);

    /**
     * Sample usage: curl $HOST:$PORT/destination?travelPackageId=1
     *
     * @return the destinations found, or null if none found
     */
    @GetMapping(
            value    = "/destination",
            produces = "application/json")
    Destination getDestination(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}
