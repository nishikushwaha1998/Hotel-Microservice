package com.project.hotel.services.impl;

import com.project.hotel.entities.Hotel;
import com.project.hotel.exceptions.ResourceNotFoundException;
import com.project.hotel.repositories.HotelRepository;
import com.project.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelID = UUID.randomUUID().toString();
        hotel.setId(hotelID);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found !!"));
    }
}
