package com.salesianostriana.dam.proyectofinal.repository;

/**Clase Repository de los Usuarios, que implementa Jpa
 * @author alediaz
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectofinal.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	/**Método el cual busca al usuario por su correo electrónico
	 * 
	 * @param correo
	 * @return el usuario encontrado mediante su correo electrónico
	 */
	public Usuario findFirstByCorreo(String correo);

}
