package com.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author alediaz
 * @version 1.5 Clase Model de los Productos que se venderán en la aplicación
 */
@Data
@NoArgsConstructor
@Entity
public class Producto {

	private String nombre, descripcion;
	private LocalDate fechaPubl; // Fecha en la cual el Producto ha salido al mercado de la tienda
	private double pvp; // Precio del producto
	private boolean stock; // El valor será "true" si está disponible-en stock; y "false" si no queda
							// ninguna unidad del producto
	private long idProducto;

	@ManyToOne
	private Categoria categoria; // La categoría que se le asociará al Producto para especificar su grupo dentro
									// de la tienda.

	@ManyToOne
	private LineaPedido lineaPedido;


	/**
	 * Constructor de la clase Producto
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param fechaPubl
	 * @param pvp
	 * @param tagProducto
	 * @param stock
	 * @param idProducto
	 */
	public Producto(String nombre, String descripcion, LocalDate fechaPubl, double pvp, boolean stock, long idProducto,
			Categoria categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaPubl = fechaPubl;
		this.pvp = pvp;
		this.stock = stock;
		this.idProducto = idProducto;
		this.categoria = categoria;
	}

}
