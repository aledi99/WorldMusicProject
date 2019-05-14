package com.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
