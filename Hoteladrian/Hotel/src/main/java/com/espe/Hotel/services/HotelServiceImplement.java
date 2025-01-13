package com.espe.Hotel.services;

import com.espe.Hotel.model.entity.Hotel;
import com.espe.Hotel.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImplement implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) repository.findAll();
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
