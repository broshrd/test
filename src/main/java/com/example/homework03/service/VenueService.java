package com.example.homework03.service;

import com.example.homework03.model.Venue;
import com.example.homework03.model.request.venueRequest.VenueRequest;

import java.util.List;


public interface VenueService {


    List<Venue> getAllVenues(Integer offset,Integer limit);

    Venue getVenueById(Integer id);

    Venue insertVenue(VenueRequest venueRequest);

    Venue updateVenue(VenueRequest venueRequest, Integer id);


    Venue deleteVenus(Integer id);
}
