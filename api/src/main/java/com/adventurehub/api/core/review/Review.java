package com.adventurehub.api.core.review;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Integer reviewId;
    private Integer userId;
    private Integer tripId;
    private String comment;
    private int rating;
    private String serviceAddress;
}
