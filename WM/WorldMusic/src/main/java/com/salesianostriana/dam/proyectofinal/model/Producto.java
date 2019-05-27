package com.salesianostriana.dam.proyectofinal.model;



import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@NoArgsConstructor
@Entity
public class Producto extends Servicio {

	
	private String nombreCategoria;
	
	
	
	public Producto(long id, String nombre, String descripcion, String image, double pvp, boolean stock, LocalDate fechaPubl,
		String nombreCategoria, Categoria categoria, LineaPedido lineaPedido) {
		super(id, nombre, descripcion, image, pvp, stock, fechaPubl );
		this.nombreCategoria = nombreCategoria;
		this.categoria = categoria;
		this.lineaPedido = lineaPedido;
	}

	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private LineaPedido lineaPedido;
}