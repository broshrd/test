package com.example.homework03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Events {
    private Integer eventId;
    private String eventName;
    private Date eventDate;
    private Venue venue;
    List<Attendee> attendees;
}
