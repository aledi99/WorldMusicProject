package com.salesianostriana.dam.proyectofinal.model;

/** Clase Model de los Conciertos que contendrá la página
 * @author alediaz
 */
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

	
	private String artista;//El/Los artista/s del concierto
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaConc;//La fecha en la cual se va a hacer el concierto
	
	private String lugarConc;//El lugar en el que se va a producir el concierto
	
	
	/**
	 * Constructor con parámetros
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param image
	 * @param pvp
	 * @param stock
	 * @param fechaPubl
	 * @param artista
	 * @param fechaConc
	 * @param lugarConc
	 * @param lineaPedido
	 */
	public Concierto(long id, String nombre, String descripcion, String image, double pvp, boolean stock, LocalDate fechaPubl,
			 String artista, LocalDate fechaConc, String lugarConc, LineaPedido lineaPedido) {
		super(id, nombre, descripcion, image, pvp, stock, fechaPubl);

		this.artista = artista;
		this.fechaConc = fechaConc;
		this.lugarConc = lugarConc;
		this.lineaPedido = lineaPedido;
	}



	@ManyToOne
	private LineaPedido lineaPedido;//Asociación ManyToOne con la clase Model LineaPedido
}