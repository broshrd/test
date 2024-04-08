package com.example.homework03.service;

import com.example.homework03.model.Attendee;
import com.example.homework03.model.request.attendeeRequest.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
   

    List<Attendee> getAllAttendee(Integer offset,Integer limit);

    Attendee getAttendeeById(Integer id);

    Attendee insertAttendee(AttendeeRequest attendeeRequest);

    Attendee updateAttendee(AttendeeRequest attendeeRequest, Integer id);

    Attendee deleteAttendee(Integer id);
}
