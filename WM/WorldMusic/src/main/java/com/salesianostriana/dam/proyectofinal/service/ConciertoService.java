package com.salesianostriana.dam.proyectofinal.service;

/**Clase Service de los Conciertos
 * @author alediaz
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Concierto;
import com.salesianostriana.dam.proyectofinal.repository.ConciertoRepository;

@Service
public class ConciertoService extends BaseService<Concierto, Long, ConciertoRepository> {
	
	@Autowired
	private ConciertoRepository repositorio;//Instancia de la clase ConciertoRepository

	/**
	 * Encuentra todos los Conciertos paginados
	 * @param pageable
	 * @return todos los Conciertos paginados
	 */
	public Page<Concierto> findAllPageable(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	/**
	 * Muestra los resultados filtrados según el nombre buscado
	 * @param nombre
	 * @param pageable
	 * @return el resultado de la búsqueda filtrada
	 */
	public  Page<Concierto> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
	{
		return repositorio.findByNombreContainingIgnoreCase(nombre, pageable);
	}
	
	

}
