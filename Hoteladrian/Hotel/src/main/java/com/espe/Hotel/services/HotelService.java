package com.espe.Hotel.services;

import com.espe.Hotel.model.entity.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<Hotel> findAll();
    Optional<Hotel> findById(Long id);
    Hotel save(Hotel hotel);
    void deleteById(Long id);
}
