package com.salesianostriana.dam.proyectofinal.model;

/**Clase Model del Servicio (clase madre) que atenderá la tienda: Productos y Conciertos
 * @author alediazç
 */

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
	private long id;//id de los servicios
	
	private String nombre, descripcion, image;//El nombre, la descripción y la imagen de los servicios
	private double pvp; // Precio del producto
	private boolean stock; // El valor será "true" si está disponible-en stock; y "false" si no queda
							// ninguna unidad del producto
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaPubl; // Fecha en la cual el Producto ha salido al mercado de la tienda

}
