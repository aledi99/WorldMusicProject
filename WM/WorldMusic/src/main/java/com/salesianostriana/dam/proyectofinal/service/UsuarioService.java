package com.salesianostriana.dam.proyectofinal.service;

/**Clase Service de los Usuarios
 * @author alediaz
 */

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Usuario;
import com.salesianostriana.dam.proyectofinal.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {

	/**
	 * Busca a un Usuario según su correo electrónico
	 * @param correo
	 * @return el Usuario buscado por su correo electrónico
	 */
	public Usuario buscarPorCorreo(String correo) {
		return repositorio.findFirstByCorreo(correo);
	}
}
