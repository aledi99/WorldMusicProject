package com.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Usuario {

	private String nombre, apellidos, nick, correo, direccion, provincia, contrasenya;
	private LocalDate fechaNac;
	private int codPostal;
	private boolean usuarioAdmin;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUsuario;

	public Usuario(String nombre, String apellidos, String nick, String correo, String direccion, String provincia, String contrasenya,
			LocalDate fechaNac, int codPostal, boolean usuarioAdmin, long idUsuario) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.direccion = direccion;
		this.correo = correo;
		this.provincia = provincia;
		this.contrasenya = contrasenya;
		this.fechaNac = fechaNac;
		this.codPostal = codPostal;
		this.usuarioAdmin = usuarioAdmin;
		this.idUsuario = idUsuario;
	}

}
