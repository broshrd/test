package com.example.homework03.repository;

import com.example.homework03.model.Events;
import com.example.homework03.model.request.eventRequest.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select( "select * from events  LIMIT #{limit} OFFSET #{offset}")
    @Results(id = "events" ,value = {
            @Result(property = "eventId" ,column = "event_id"),
            @Result(property = "eventName" ,column = "event_name"),
            @Result(property = "eventDate" ,column = "event_date"),
            @Result(property = "venue" ,column = "venue_id" ,one = @One(select = "com.example.homework03.repository.VenueReposotory.getVenueById")),
            @Result(property = "attendees",column = "event_id" ,many = @Many(select = "com.example.homework03.repository.AttendeeRepository.getAttendeeByEventId"))
    })
    List<Events> getAllEvent(Integer offset,Integer limit);

    @Select("select * from events where event_id=#{id}")
    @ResultMap("events")
    Events getEventById(Integer id);

    @Select("insert into events( event_name, event_date, venue_id) values (#{event.eventName},#{event.eventDate},#{event.venueId}) RETURNING *")
    @ResultMap("events")
    Events insertEvent(@Param("event") EventRequest eventRequest);

    @Insert("""
            insert into event_attendee values (#{eventId} ,#{attendeeId})
            """)
    @ResultMap("events")
    void inserttoEvent_attendee(Integer eventId, Integer attendeeId);

    @Select("update events set event_name=#{ev.eventName},event_date=#{ev.eventDate},venue_id=#{ev.venueId} where event_id=#{id} RETURNING *")
    @ResultMap("events")
    Events updateEvent(@Param("ev") EventRequest eventRequest, Integer id);

//    @Select("")
//    @ResultMap("events")
//    Integer removeEventAttendeeById();

    @Delete("delete from events where event_id=#{id}")
    boolean deleteEvent(Integer id);

    @Delete("delete from event_attendee where event_id = #{eventId}")
    void removeEventAttendeeByEventId(Integer eventId);
}
