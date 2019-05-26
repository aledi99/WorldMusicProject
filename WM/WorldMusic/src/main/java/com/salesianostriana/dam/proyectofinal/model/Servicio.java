package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@MappedSuperclass
@NoArgsConstructor
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre, descripcion;
	private double pvp; // Precio del producto
	private boolean stock; // El valor será "true" si está disponible-en stock; y "false" si no queda
							// ninguna unidad del producto
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPubl; // Fecha en la cual el Producto ha salido al mercado de la tienda

}
