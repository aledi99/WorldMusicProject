package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Carrito {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCompra;

	private LocalDate fechaCompra;

	@OneToMany
	private List<LineaPedido> lineaPedido = new ArrayList<>();
	
	
}
