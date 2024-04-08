package com.example.homework03.controller;

import com.example.homework03.model.APIRespone.APIRespone;
import com.example.homework03.model.Events;
import com.example.homework03.model.request.eventRequest.EventRequest;
import com.example.homework03.service.EventsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

@RestController
@RequestMapping("api/v1/event")
public class eventController {
        private final EventsService eventsService;

    public eventController(EventsService eventsService) {
        this.eventsService = eventsService;
    }
    @GetMapping
    public ResponseEntity<APIRespone<List<Events>>> getAllEvent(
            @RequestParam (defaultValue = "1") @Positive Integer offset,
            @RequestParam (defaultValue = "3") @Positive Integer limit
    ){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "All Event is get successfully.",
                        eventsService.getAllEvent(offset,limit),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIRespone<Events>> getEventById(@PathVariable @Valid Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Event is get sucessfully.",
                        eventsService.getEventById(id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );

    }
    @PostMapping
    public ResponseEntity<APIRespone<Events>> insertEventById(@RequestBody @Valid EventRequest eventRequest){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "event is inserted successfully.",
                        eventsService.insertEvent(eventRequest),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<APIRespone<Events>> updateEvent(@RequestBody @Valid EventRequest eventRequest,@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(
                new APIRespone<>(
                        "Event is updated successfully.",
                        eventsService.updateEvent(eventRequest,id),
                        HttpStatus.OK,
                        LocalDateTime.now()
                )
        );
    }
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable @Valid Integer id){
        return eventsService.deleteEvent(id);
    }
}
