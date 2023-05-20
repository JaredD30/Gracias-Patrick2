package com.adventurehub.api.composite.travelPackage;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.adventurehub.api.composite.travelPackage.resource.CreateTravelPackageResource;

import java.util.List;

@Api(description = "REST API for composite travel package information.")
public interface TravelPackageCompositeService {

    /**
     * Sample usage: curl $HOST:$PORT/travelPackage-composite
     *
     * @return the composite travelPackage info
     */
    @GetMapping(
        value    = "/travelPackage-composite",
        produces = "application/json")
    List<TravelPackageAggregate> getCompositeTravelPackages();

    @GetMapping(
            value    = "/travelPackage-composite/{travelPackageId}",
            produces = "application/json")
    TravelPackageAggregate getCompositeTravelPackage(@PathVariable Integer travelPackageId);

    @PostMapping(
            value    = "/travelPackage-composite",
            consumes = "application/json")
    void createCompositeTravelPackage(@RequestBody CreateTravelPackageResource body);
}
