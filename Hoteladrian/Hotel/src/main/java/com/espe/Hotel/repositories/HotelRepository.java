package com.espe.Hotel.repositories;

import com.espe.Hotel.model.entity.Hotel;
import org.springframework.data.repository.CrudRepository;

public interface HotelRepository extends CrudRepository<Hotel, Long> {

}
