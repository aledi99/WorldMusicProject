package com.proyectofinal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Concierto extends Producto {

	private String artista, descripcion;
	private LocalDateTime fechaConc;
	private String lugarConc;
	private long idConcierto;
	
	
	public Concierto(String artista, String descripcion, LocalDateTime fechaConc, String lugarConc, long idConcierto) {
		super();
		this.artista = artista;
		this.descripcion = descripcion;
		this.fechaConc = fechaConc;
		this.lugarConc = lugarConc;
		this.idConcierto = idConcierto;
	}
	
	
	
	
	
	
	
	
}
