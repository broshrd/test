package com.example.homework03.controller;

import com.example.homework03.model.APIRespone.APIRespone;
import com.example.homework03.model.Venue;
import com.example.homework03.model.request.venueRequest.VenueRequest;
import com.example.homework03.service.VenueService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/venue")
public class VenuesController {
    private final VenueService venueService;

    public VenuesController(VenueService venueService) {
        this.venueService = venueService;
    }
    @GetMapping
    public ResponseEntity<APIRespone<List<Venue>>> getAllVenues(
                    @RequestParam (defaultValue = "1") @Positive Integer offset,
                    @RequestParam (defaultValue = "3") @Positive Integer limit ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Venues is get successfully",
                        venueService.getAllVenues(offset,limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIRespone<Venue>> getvenueById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Venues is get successfully.",
                        venueService.getVenueById(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @PostMapping
    public ResponseEntity<APIRespone<Venue>> insertVenue(@RequestBody @Valid VenueRequest venueRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Venue is created successfully.",
                        venueService.insertVenue(venueRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIRespone<Venue>> updateVenue(@RequestBody @Valid VenueRequest venueRequest,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Venue is updated successfully.",
                        venueService.updateVenue(venueRequest,id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIRespone<Venue>> deleteVenue(@PathVariable @Valid Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Venue is deleted successfully",
                        venueService.deleteVenus(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );

    }

}
