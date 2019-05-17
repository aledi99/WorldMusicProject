package com.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.model.ProductoModel;

public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {

}
