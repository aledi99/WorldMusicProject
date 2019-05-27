package com.salesianostriana.dam.proyectofinal.service;

/**Clase Service de los Productos
 * @author alediaz
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
	
	@Autowired
	private ProductoRepository repositorio;//Instancia de la clase ProductoRepository

	/**
	 * Encuentra todos los Productos paginados
	 * @param pageable
	 * @return todos los Productos paginados
	 */
	public Page<Producto> findAllPageable(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	/**
	 * Muestra los resultados filtrados según el nombre buscado
	 * @param nombre
	 * @param pageable
	 * @return el resultado de la búsqueda filtrado
	 */
	public  Page<Producto> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
	{
		return repositorio.findByNombreContainingIgnoreCase(nombre, pageable);
	}
	
	/**
	 * Muestra los resultados filtrados según el nombre de la categoría buscado
	 * @param nombreCategoria
	 * @param pageable
	 * @return el resultado de la búsqueda filtrado
	 */
	public  Page<Producto> findByNombreCategoriaContainingIgnoreCasePageable(String nombreCategoria, Pageable pageable)
	{
		return repositorio.findByNombreCategoriaContainingIgnoreCase(nombreCategoria, pageable);
	}
	
}
