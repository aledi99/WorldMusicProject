package com.proyectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Carrito {

	// Duda Composición
	@OneToMany
	private List<LineaPedido> lineaPedido;

	private LocalDate fechaCompra;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompra;

	public Carrito(List<LineaPedido> lineaPedido, LocalDate fechaCompra, long idCompra) {
		super();
		lineaPedido = new ArrayList<>();
		this.fechaCompra = fechaCompra;
		this.idCompra = idCompra;
	}

}
