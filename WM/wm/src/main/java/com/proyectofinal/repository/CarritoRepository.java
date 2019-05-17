package com.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.model.CarritoModel;

public interface CarritoRepository extends JpaRepository<CarritoModel, Long> {

}
