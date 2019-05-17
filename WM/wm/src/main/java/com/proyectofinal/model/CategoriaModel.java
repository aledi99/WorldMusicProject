package com.proyectofinal.model;

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
public class CategoriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategoria;// El id que gestionará las distintas categorías que existen en la tienda
	
	private String nombreC; // El nombre de la categoría
	
	@OneToMany
	private List<ProductoModel> producto = new ArrayList<>();
}
