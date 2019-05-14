package com.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectofinal.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
