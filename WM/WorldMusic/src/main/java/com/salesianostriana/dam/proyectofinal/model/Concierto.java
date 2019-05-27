package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@DiscriminatorValue("C")
public class Concierto extends Servicio {

	
	private String artista;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConc;
	
	private String lugarConc;
	
	
	
	public Concierto(long id, String nombre, String descripcion, String image, double pvp, boolean stock, LocalDate fechaPubl,
			 String artista, LocalDate fechaConc, String lugarConc, LineaPedido lineaPedido) {
		super(id, nombre, descripcion, image, pvp, stock, fechaPubl);

		this.artista = artista;
		this.fechaConc = fechaConc;
		this.lugarConc = lugarConc;
		this.lineaPedido = lineaPedido;
	}



	@ManyToOne
	private LineaPedido lineaPedido;
}