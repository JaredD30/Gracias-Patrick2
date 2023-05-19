package se.magnus.api.composite.travelPackage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class SeasonSummary {
    private Integer seasonId;
    private String name;

    public SeasonSummary(Integer seasonId, String name) {
        this.seasonId = seasonId;
        this.name = name;
    }

    public Integer getSeasonId() {
        return seasonId;
    }

    public String getName() {
        return name;
    }
}
