package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProducto;// El id que gestionará los distintos conciertos que existen en la tienda

	private String nombre, descripcion;
	private LocalDate fechaPubl; // Fecha en la cual el Producto ha salido al mercado de la tienda
	private double pvp; // Precio del producto
	private boolean stock; // El valor será "true" si está disponible-en stock; y "false" si no queda
							// ninguna unidad del producto
	@ManyToOne
	private Categoria categoria;
	
	@ManyToOne
	private LineaPedido lineaPedido;
}