package com.example.homework03.service.VenueServiceImpl;

import com.example.homework03.Exception.BadRequestException;
import com.example.homework03.Exception.NotFoundException;
import com.example.homework03.model.Venue;
import com.example.homework03.model.request.venueRequest.VenueRequest;
import com.example.homework03.repository.VenueReposotory;
import com.example.homework03.service.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    private final VenueReposotory venueReposotory;

    public VenueServiceImpl(VenueReposotory venueReposotory) {
        this.venueReposotory = venueReposotory;
    }

    @Override
    public List<Venue> getAllVenues(Integer offset,Integer limit) {
        offset=(offset-1)*limit;

        return venueReposotory.getAllvenues(offset,limit);
    }

    @Override
    public Venue getVenueById(Integer id) {
        Venue venue =venueReposotory.getVenueById(id);
        if (venue== null){
            throw new NotFoundException("Venue " + id + " not found");
        }
        return venueReposotory.getVenueById(id);
    }

    @Override
    public Venue insertVenue(VenueRequest venueRequest) {
        return venueReposotory.insertVenue(venueRequest);
    }

    @Override
    public Venue updateVenue(VenueRequest venueRequest, Integer id) {
        Venue venue =venueReposotory.updateVenue(venueRequest,id);
        if (venue== null){
            throw new NotFoundException("Venue " + id + " not found");
        }
        return venueReposotory.updateVenue(venueRequest,id);
    }

    @Override
    public Venue deleteVenus(Integer id) {
        Venue venue =venueReposotory.deleteVenues(id);
        if (venue==null){
            throw new NotFoundException("Venue " + id + " not found");
        }
        return  venueReposotory.deleteVenues(id);
    }

}
