package se.magnus.api.core.travelpackage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TravelPackageService {

    @PostMapping(
            value    = "/travelPackage",
            produces = "application/json")
    TravelPackage createTravelPackage(@RequestBody TravelPackage body);

    /**
     * Sample usage: curl $HOST:$PORT/travelPackages
     *
     * @return the travelPackages
     */
    @GetMapping(
            value    = "/travelPackage",
            produces = "application/json")
    List<TravelPackage> getTravelPackages();
}
