package se.magnus.api.core.activity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ActivityService {

    @PostMapping(
            value    = "/activity",
            produces = "application/json")
    Activity createActivity(@RequestBody Activity body);

    /**
     * Sample usage: curl $HOST:$PORT/activity?itineraryId=1
     *
     * @return the activity found, or null if none found
     */
    @GetMapping(
            value    = "/activity",
            produces = "application/json")
    List<Activity> getActivities(@RequestParam(value = "itineraryId", required = true) Integer itineraryId);
}
