package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "travel_package_details")
public class TravelPackageDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String imageUrl;
}
