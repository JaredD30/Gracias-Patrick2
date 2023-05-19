package se.magnus.api.composite.travelPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class DestinationSummary {
    private Integer destinationId;
    private String name;
    private String description;

    public DestinationSummary(Integer destinationId, String name, String description) {
        this.destinationId = destinationId;
        this.name = name;
        this.description = description;
    }

    public Integer getDestinationId() {
        return destinationId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
