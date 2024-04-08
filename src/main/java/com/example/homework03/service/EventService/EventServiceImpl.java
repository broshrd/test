package com.example.homework03.service.EventService;

import com.example.homework03.Exception.NotFoundException;
import com.example.homework03.model.Events;
import com.example.homework03.model.request.eventRequest.EventRequest;
import com.example.homework03.repository.EventRepository;
import com.example.homework03.service.EventsService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventServiceImpl implements EventsService {
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Events> getAllEvent(Integer offset,Integer limit) {
        offset=(offset-1)*limit;
        return eventRepository.getAllEvent(offset,limit);
    }

    @Override
    public Events getEventById(Integer id) {
        Events event =eventRepository.getEventById(id);
        if (event == null){
            throw new NotFoundException("Event "+id+" is not founded");
        }
        return eventRepository.getEventById(id);
    }

    @Override
    public Events insertEvent(EventRequest eventRequest) {
        Integer eventId = eventRepository.insertEvent(eventRequest).getEventId();

        for(Integer attendeeid :eventRequest.getAttendees()){
            eventRepository.inserttoEvent_attendee(eventId,attendeeid);
        }
        return getEventById(eventId);
    }

    @Override
    public Events updateEvent(EventRequest eventRequest, Integer id) {
        Integer eventId =eventRepository.updateEvent(eventRequest,id).getEventId();
       eventRepository.removeEventAttendeeByEventId(eventId);

        for (Integer attendeeid: eventRequest.getAttendees()){
            eventRepository.inserttoEvent_attendee(eventId,attendeeid);
        }
        return getEventById(eventId);
    }

    @Override
    public String deleteEvent(Integer id) {
        boolean isDeleted= eventRepository.deleteEvent(id);
        String message="";
        if(isDeleted){
            message="Event is deleted successfully";
        }
        else{
            throw new NotFoundException("Event "+id+" not founded");
        }
           // message="Event is not found";
        return message;
    }
}
