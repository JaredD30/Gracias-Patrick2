package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private Integer tripId;
    private String comment;
    private int rating;
}
