package com.salesianostriana.dam.proyectofinal.model;

/**Clase Model de los Productos que habrá en la página
 * @author alediaz
 */

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

	
	private String nombreCategoria;//El nombre de la categoría a la cual está asociado el producto
	
	
	/**
	 * Constructor con parámetros
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param image
	 * @param pvp
	 * @param stock
	 * @param fechaPubl
	 * @param nombreCategoria
	 * @param categoria
	 * @param lineaPedido
	 */
	public Producto(long id, String nombre, String descripcion, String image, double pvp, boolean stock, LocalDate fechaPubl,
		String nombreCategoria, Categoria categoria, LineaPedido lineaPedido) {
		super(id, nombre, descripcion, image, pvp, stock, fechaPubl );
		this.nombreCategoria = nombreCategoria;
		this.categoria = categoria;
		this.lineaPedido = lineaPedido;
	}

	@ManyToOne
	private Categoria categoria;//Asociación ManyToOne con la clase Model Categoría
	
	@ManyToOne
	private LineaPedido lineaPedido;//Asociación ManyToOne con la clase Model LineaPedido
}