package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Concierto extends Producto {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConcierto;// El id que gestionará los distintos conciertos que existen en la tienda
	
	private String artista;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConc;
	
	private String lugarConc;
}