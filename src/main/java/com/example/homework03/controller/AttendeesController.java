package com.example.homework03.controller;

import com.example.homework03.model.APIRespone.APIRespone;
import com.example.homework03.model.Attendee;
import com.example.homework03.model.request.attendeeRequest.AttendeeRequest;
import com.example.homework03.service.AttendeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/Attendees")
public class AttendeesController {
    private final AttendeeService attendeeService;

    public AttendeesController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    @GetMapping
    public ResponseEntity<APIRespone<List<Attendee>>> getallAttendee(
            @RequestParam (defaultValue = "1") @Positive Integer offset,
            @RequestParam(defaultValue = "3") @Positive Integer limit
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "All Attendees is get successfully.",
                        attendeeService.getAllAttendee(offset,limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIRespone<Attendee>> getAttendeeById(@PathVariable @Valid Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Attendee is get successfully",
                        attendeeService.getAttendeeById(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @PostMapping
    public ResponseEntity<APIRespone<Attendee>> insertAttendee(@RequestBody @Valid AttendeeRequest attendeeRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Attendee is created successfully.",
                        attendeeService.insertAttendee(attendeeRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIRespone<Attendee>> updateAttendee(@RequestBody @Valid AttendeeRequest attendeeRequest, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Attendee is updated successfully",
                        attendeeService.updateAttendee(attendeeRequest,id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<APIRespone<Attendee>> deleteAttendee(@PathVariable @Valid Integer id){

        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Attendee is deleted sucessfully.",
                        attendeeService.deleteAttendee(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );

    }
}
