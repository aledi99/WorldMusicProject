package com.salesianostriana.dam.proyectofinal.repository;

/**Clase Repository de las Líneas de Pedido, que implementa Jpa
 * @author alediaz
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.LineaPedido;


@Repository
public interface LineaPedidoRepository extends JpaRepository<LineaPedido, Long> {

}
