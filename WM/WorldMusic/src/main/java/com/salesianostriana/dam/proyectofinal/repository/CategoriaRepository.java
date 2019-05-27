package com.salesianostriana.dam.proyectofinal.repository;

/**Clase Repository de las Categorías que implementa Jpa
 * @author alediaz
 */
import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectofinal.model.Categoria;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
