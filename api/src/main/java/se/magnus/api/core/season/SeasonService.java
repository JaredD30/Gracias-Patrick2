package se.magnus.api.core.season;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface SeasonService {

//    @PostMapping(
//            value    = "/season",
//            produces = "application/json")
//    Season createSeason(@RequestBody Season body);

    /**
     * Sample usage: curl $HOST:$PORT/season?travelPackageId=1
     *
     * @return the season found, or null if none found
     */
    @GetMapping(
            value    = "/season",
            produces = "application/json")
    Season getSeason(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}
