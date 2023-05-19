package se.magnus.api.core.itinerary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ItineraryService {

    /**
     * Sample usage: curl $HOST:$PORT/itinerary?travelPackageId=1
     *
     * @param travelPackageId
     * @return the itineraries for the trip
     */
    @GetMapping(
            value    = "/itinerary",
            produces = "application/json")
    List<Itinerary> getItineraries(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}
