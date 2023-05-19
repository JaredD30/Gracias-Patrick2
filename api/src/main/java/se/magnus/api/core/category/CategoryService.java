package se.magnus.api.core.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface CategoryService {

//    @PostMapping(
//            value    = "/category",
//            produces = "application/json")
//    Category createCategory(@RequestBody Category body);

    /**
     * Sample usage: curl $HOST:$PORT/category?travelPackageId=1
     *
     * @return the destinations found, or null if none found
     */
    @GetMapping(
            value    = "/category",
            produces = "application/json")
    Category getCategory(@RequestParam(value = "travelPackageId", required = true) Integer travelPackageId);
}
