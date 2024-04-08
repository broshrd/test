package com.example.homework03.service;

import com.example.homework03.model.Events;
import com.example.homework03.model.request.eventRequest.EventRequest;

import java.util.List;

public interface EventsService {
    List<Events> getAllEvent(Integer offset,Integer limit);

    Events getEventById(Integer id);

    Events insertEvent(EventRequest eventRequest);

    String deleteEvent(Integer id);

    Events updateEvent(EventRequest eventRequest, Integer id);


}
