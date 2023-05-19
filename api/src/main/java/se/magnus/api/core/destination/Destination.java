package se.magnus.api.core.destination;

import lombok.*;
import se.magnus.api.core.itinerary.Itinerary;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Destination {
    private Integer destinationId;
    private String name;
    private String description;
    private String serviceAddress;

    public Destination(){}

    public Destination(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Integer destinationId) {
        this.destinationId = destinationId;
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

    public String getServiceAddress() {
        return serviceAddress;
    }

    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }
}
