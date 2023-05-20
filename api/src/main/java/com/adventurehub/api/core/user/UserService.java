package com.adventurehub.api.core.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    @PostMapping(
            value    = "/activity",
            produces = "application/json")
    User createDestination(@RequestBody User body);

    /**
     * Sample usage: curl $HOST:$PORT/activity?itineraryId=1
     *
     * @return the destinations found, or null if none found
     */
    @GetMapping(
            value    = "/activity",
            produces = "application/json")
    List<User> getActivities(@RequestParam(value = "itineraryId", required = true) Integer itineraryId);
}
