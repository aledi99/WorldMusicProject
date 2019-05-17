package com.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LineaPedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLineaPedido;// El id que gestionará los distintos conciertos que existen en la tienda

	private int cantidad;

	@OneToMany
	private List<ProductoModel> producto = new ArrayList<>();

	@ManyToOne
	private CarritoModel carrito;
}