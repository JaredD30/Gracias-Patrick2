package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "travel_packages")
@NoArgsConstructor
@AllArgsConstructor
public class TravelPackageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer categoryId;
    private Integer destinationId;
    private Integer seasonId;
    private String name;
    private String description;
    private String groupSize;
    private String status;
    private Date startDate;
    private Date endDate;

    public Integer getId() {
        return id;
    }
}
