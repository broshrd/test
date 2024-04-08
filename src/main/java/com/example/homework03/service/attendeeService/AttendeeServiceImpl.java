package com.example.homework03.service.attendeeService;

import com.example.homework03.Exception.NotFoundException;
import com.example.homework03.model.Attendee;
import com.example.homework03.model.request.attendeeRequest.AttendeeRequest;
import com.example.homework03.repository.AttendeeRepository;
import com.example.homework03.service.AttendeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    public AttendeeServiceImpl(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    @Override
    public List<Attendee> getAllAttendee(Integer offset, Integer limit) {
        offset=(offset-1)*limit;
        return attendeeRepository.getAllAttendees(offset,limit);
    }

    @Override
    public Attendee getAttendeeById(Integer id) {

        Attendee attendee =attendeeRepository.getAttendeeById(id);
        if (attendee == null){
            throw new NotFoundException("attendee "+id+" not founded");
        }
        return attendeeRepository.getAttendeeById(id);
    }

    @Override
    public Attendee insertAttendee(AttendeeRequest attendeeRequest) {
        return attendeeRepository.insertAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendee(AttendeeRequest attendeeRequest, Integer id) {
        Attendee attendee =attendeeRepository.getAttendeeById(id);
        if (attendee == null){
            throw new NotFoundException("attendee "+id+" not founded");
        }
        return attendeeRepository.updateAttendee(attendeeRequest,id);
    }

    @Override
    public Attendee deleteAttendee(Integer id) {
        return attendeeRepository.deleteAttendee(id);

    }
}
