package com.salesianostriana.dam.proyectofinal.model;

/**Clase Model de las Líneas de Pedido del Carrito
 * @author alediaz
 */
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
public class LineaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLineaPedido;// El id que gestionará los distintos conciertos que existen en la tienda

	private int cantidad;//La cantidad de productos que habrá en la linea de pedido

	@OneToMany
	private List<Producto> producto = new ArrayList<>();//Asociación OneToMany con la clase Model Producto
	
	@OneToMany
	private List<Concierto> concierto = new ArrayList<>();//Asociación OneToMany con la clase Model Concierto

}