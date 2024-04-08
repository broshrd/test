package com.example.homework03.repository;

import com.example.homework03.model.Attendee;
import com.example.homework03.model.request.attendeeRequest.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Select("select * from attendees LIMIT #{limit} OFFSET #{offset}")
    @Results(id = "attendee", value = {
            @Result(property = "attendeeId",column = "attendee_id"),
            @Result(property = "attendeeName" ,column = "attendee_name")
    })
    List<Attendee> getAllAttendees(Integer offset,Integer limit);

    @Select("select * from attendees where attendee_id=#{id}")
    @ResultMap("attendee")
    Attendee getAttendeeById(Integer id);

    @Select("insert into attendees (attendee_name,email) values (#{attendee.attendeeName},#{attendee.email}) RETURNING *")
    @ResultMap("attendee")
    Attendee insertAttendee(@Param("attendee") AttendeeRequest attendeeRequest);

    @Select("update attendees set attendee_name= #{attendee.attendeeName}, email= #{attendee.email} where attendee_id=#{id} RETURNING *")
    @ResultMap("attendee")
    Attendee updateAttendee(@Param("attendee") AttendeeRequest attendeeRequest, Integer id);

    @Select("delete from attendees where attendee_id=#{id} RETURNING *")
    @ResultMap("attendee")
    Attendee deleteAttendee(Integer id);


    @Select("""
            select at.attendee_id,at.attendee_name,at.email from attendees at inner join
                event_attendee eat on at.attendee_id=eat.attendee_id where eat.event_id=#{eventid};
""")
    @ResultMap("attendee")
    List<Attendee> getAttendeeByEventId(Integer eventid);
}
