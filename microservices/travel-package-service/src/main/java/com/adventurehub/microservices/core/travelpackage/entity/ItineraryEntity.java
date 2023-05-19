package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itineraries")
public class ItineraryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer travelPackageId;
    private Date startDate;
    private Date endDate;
    private String origin;
    private String destination;
    private Double latitude;
    private Double longitude;
}
