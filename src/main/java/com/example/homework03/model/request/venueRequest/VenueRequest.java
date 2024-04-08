package com.example.homework03.model.request.venueRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotBlank
    @NotNull
    private String venueName;
    @NotBlank
    @NotNull
    private String location;
}
