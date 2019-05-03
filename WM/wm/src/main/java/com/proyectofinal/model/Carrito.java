package com.proyectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Carrito {

	// Duda Composición
	private List<LineaPedido> lineaPedido;

	private LocalDate fechaCompra;
	private long idCompra;

	public Carrito(List<LineaPedido> lineaPedido, LocalDate fechaCompra, long idCompra) {
		super();
		lineaPedido = new ArrayList<>();
		this.fechaCompra = fechaCompra;
		this.idCompra = idCompra;
	}

}
