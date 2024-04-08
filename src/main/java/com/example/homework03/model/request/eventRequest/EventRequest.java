package com.example.homework03.model.request.eventRequest;

import com.example.homework03.model.Attendee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRequest {
    @NotNull
    @NotBlank
    private String eventName;
    @NotNull
    @NotBlank
    private Date eventDate;
    @NotNull
    @NotBlank
    private Integer venueId;
    @NotNull
    @NotBlank
    List<Integer> attendees;
}
