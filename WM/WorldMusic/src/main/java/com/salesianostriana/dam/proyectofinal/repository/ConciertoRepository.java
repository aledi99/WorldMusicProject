package com.salesianostriana.dam.proyectofinal.repository;

/**Clase Repository de los Conciertos, que implementa Jpa
 * @author alediaz
 */

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.Concierto;

@Repository
public interface ConciertoRepository extends JpaRepository<Concierto, Long> {

	/**
	 * Método que devuelve una búsqueda realizada por nombre y le tenemos que pasar
	 * el atributo por el cual deseemos buscar, en nuestro caso, por nombre
	 * ignorando las mayúsculas
	 * 
	 * @param nombre Nombre del concierto registrado en nuestra base de datos
	 * @return devuelve el concierto buscado por nombre
	 */
	public List<Concierto> findByNombreContainingIgnoreCase(String nombre);

	/**
	 * Método que filtra los conciertos según el nombre, el cual se filtrará según la
	 * búsqueda que se haya hecho (y pagina el resultado)
	 * 
	 * @param nombre
	 * @param pageable
	 * @return el resultado filtrado y paginado
	 */
	public Page<Concierto> findByNombreContainingIgnoreCase(String nombre, Pageable pageable);

}
