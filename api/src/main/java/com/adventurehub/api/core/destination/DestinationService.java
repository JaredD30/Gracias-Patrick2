package com.adventurehub.api.core.destination;

import org.springframework.web.bind.annotation.*;

public interface DestinationService {

//    @PostMapping(
//            value    = "/destination",
//            produces = "application/json")
//    Destination createDestination(@RequestBody Destination body);

    /**
     * Sample usage: curl $HOST:$PORT/destination
     *
     * @return the destinations found, or null if none found
     */
    @GetMapping(
            value    = "/destination/{destinationId}",
            produces = "application/json")
    Destination getDestination(@PathVariable Integer destinationId);
}
