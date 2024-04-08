package com.example.homework03.repository;

import com.example.homework03.model.Venue;
import com.example.homework03.model.request.venueRequest.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueReposotory {

    @Select("select * from venues LIMIT #{limit} OFFSET #{offset}")
    @Results(id = "venueMapping",value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName",column = "venue_name")
    })
    List<Venue> getAllvenues(Integer offset,Integer limit);

    @Select("select * from venues where venue_id=#{id}")
    @ResultMap("venueMapping")
    Venue getVenueById(Integer id);

    @Select("insert into venues(venue_name,location) values (#{venue.venueName},#{venue.location}) RETURNING *")
    @ResultMap("venueMapping")
    Venue insertVenue(@Param("venue") VenueRequest venueRequest);

    @Select("update venues set venue_name=#{venue.venueName},location=#{venue.location} where venue_id=#{id} RETURNING *")
    @ResultMap("venueMapping")
    Venue updateVenue(@Param("venue") VenueRequest venueRequest, Integer id);

    @Select("delete from venues where venue_id=#{id} RETURNING *")
    @ResultMap("venueMapping")
    Venue deleteVenues(Integer id);
}
