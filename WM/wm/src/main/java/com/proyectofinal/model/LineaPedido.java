package com.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class LineaPedido {

	private int cantidad;

	@OneToMany
	private List<Producto> producto;

	public LineaPedido(int cantidad, List<Producto> producto) {
		super();
		this.cantidad = cantidad;
		producto = new ArrayList<>();
	}

}
