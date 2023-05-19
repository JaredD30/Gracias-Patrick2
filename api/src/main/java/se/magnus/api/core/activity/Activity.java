package se.magnus.api.core.activity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Activity {
    private Integer activityId;
    private Integer itineraryId;
    private String name;
    private String serviceAddress;
}
