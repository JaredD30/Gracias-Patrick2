package com.adventurehub.microservices.core.travelpackage.entity;

import lombok.*;
import se.magnus.api.core.destination.Destination;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "destinations")
public class DestinationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String name;
    private String description;

    public DestinationEntity() {}

    public DestinationEntity(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
