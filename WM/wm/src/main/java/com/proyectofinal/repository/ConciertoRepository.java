package com.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.model.Concierto;

public interface ConciertoRepository extends JpaRepository<Concierto, Long> {

}
