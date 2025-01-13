package com.espe.Hotel.controllers;

import com.espe.Hotel.model.entity.Hotel;
import com.espe.Hotel.services.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private HotelService service;

    // Crear un hotel
    // Crear un hotel
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody @Valid Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(hotel));
    }

    // Obtener todos los hoteles
    @GetMapping
    public List<Hotel> listar() {
        return service.findAll();
    }

    // Obtener un hotel por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        Optional<Hotel> hotel = service.findById(id);
        if (hotel.isPresent()) {
            return ResponseEntity.ok(hotel.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel no encontrado");
    }

    // Actualizar un hotel
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Hotel hotel, @PathVariable Long id) {
        Optional<Hotel> hotelExistente = service.findById(id);
        if (hotelExistente.isPresent()) {
            Hotel hotelActualizado = hotelExistente.get();
            hotelActualizado.setNombre(hotel.getNombre());
            hotelActualizado.setUbicacion(hotel.getUbicacion());
            hotelActualizado.setHabitaciones(hotel.getHabitaciones());
            hotelActualizado.setFechaInauguracion(hotel.getFechaInauguracion());
            return ResponseEntity.ok(service.save(hotelActualizado));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel no encontrado");
    }

    // Eliminar un hotel
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Hotel> hotel = service.findById(id);
        if (hotel.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.ok("Hotel eliminado correctamente");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel no encontrado");
    }
}
