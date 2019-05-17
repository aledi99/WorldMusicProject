package com.proyectofinal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ConciertoModel extends ProductoModel {

	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idConcierto;// El id que gestionará los distintos conciertos que existen en la tienda
	
	private String artista, descripcion;
	private LocalDateTime fechaConc;
	private String lugarConc;
}