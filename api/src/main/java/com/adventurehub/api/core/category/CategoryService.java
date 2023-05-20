package com.adventurehub.api.core.category;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {

//    @PostMapping(
//            value    = "/category",
//            produces = "application/json")
//    Category createCategory(@RequestBody Category body);

    /**
     * Sample usage: curl $HOST:$PORT/category
     *
     * @return the category found, or null if none found
     */
    @GetMapping(
            value    = "/category/{categoryId}",
            produces = "application/json")
    Category getCategory(@PathVariable Integer categoryId);
}
