package com.adventurehub.api.core.season;

import org.springframework.web.bind.annotation.*;

public interface SeasonService {

//    @PostMapping(
//            value    = "/season",
//            produces = "application/json")
//    Season createSeason(@RequestBody Season body);

    /**
     * Sample usage: curl $HOST:$PORT/season
     *
     * @return the season found, or null if none found
     */
    @GetMapping(
            value    = "/season/{seasonId}",
            produces = "application/json")
    Season getSeason(@PathVariable Integer seasonId);
}
