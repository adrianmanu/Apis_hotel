package com.espe.Hotel.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.Date;

@Entity
@Table(name = "Hoteles")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre no puede ser vacío")
    private String nombre;

    @Column(nullable = false)
    @NotEmpty(message = "La ubicación no puede ser vacía")
    private String ubicacion;

    @Column(nullable = false)
    @NotNull(message = "El número de habitaciones no puede ser nulo")
    private Integer habitaciones;

    @Column(name = "fecha_inauguracion", nullable = false)
    @NotNull(message = "La fecha de inauguración no puede ser nula")
    @Past(message = "La fecha de inauguración debe ser una fecha pasada")
    private Date fechaInauguracion;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Integer habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Date getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(Date fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }
}
