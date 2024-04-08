package com.example.homework03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    private Integer venueId;
    private String venueName;
    private String location;
}
