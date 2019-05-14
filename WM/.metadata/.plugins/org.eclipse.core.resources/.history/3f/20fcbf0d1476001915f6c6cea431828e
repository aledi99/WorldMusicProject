package com.proyectofinal.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author alediaz Clase Model de las categorías que "filtrarán" los distintos
 *         productos musicales de la tienda.
 */
@Data
@NoArgsConstructor
@Entity
public class Categoria {

	private String nombreC; // El nombre de la categoría
	private long idCategoria; // El id que gestionará las distintas categorías que existen en la tienda

	@OneToMany
	private List<Producto> contenido; // El contenido de la categoría, en la que existe una asociación con la clase
										// Producto mediante @OneToMany

	/**
	 * Constructor vacío de la clase Categoría
	 */
	public Categoria() {

	}

	/**
	 * Constructor con dos parámetros de la clase Categoría
	 * 
	 * @param nombreC
	 * @param idCategoria
	 */
	public Categoria(String nombreC, long idCategoria) {
		super();
		this.nombreC = nombreC;
		this.idCategoria = idCategoria;
	}

}
