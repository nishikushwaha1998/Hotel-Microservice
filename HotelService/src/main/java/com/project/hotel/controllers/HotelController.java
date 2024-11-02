package com.project.hotel.controllers;

import com.project.hotel.entities.Hotel;
import com.project.hotel.exceptions.ResourceNotFoundException;
import com.project.hotel.payload.ApiResponse;
import com.project.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @PostMapping
    private ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
            Hotel savedHotel = hotelService.create(hotel);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedHotel);
        }


    @GetMapping("/{hotelId}")
    private ResponseEntity<Hotel> gethotel(@PathVariable String hotelId) {

        Hotel hotel = hotelService.get(hotelId);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.get(hotelId));


    }

    @GetMapping
    private ResponseEntity<List<Hotel>> getAllHotels() {


            List<Hotel> allHotels = hotelService.getAll();
            return ResponseEntity.status(HttpStatus.CREATED).body(allHotels);


    }

}
