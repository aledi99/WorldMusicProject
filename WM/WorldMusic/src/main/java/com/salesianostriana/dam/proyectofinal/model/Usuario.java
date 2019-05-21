package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;// El id que gestionará los distintos conciertos que existen en la tienda

	private String nombre, apellidos, nick, correo, direccion, provincia, contrasenya;
	private LocalDate fechaNac;
	private int codPostal;
	private boolean usuarioAdmin;

}