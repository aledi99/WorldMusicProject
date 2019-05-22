package com.salesianostriana.dam.proyectofinal.service;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Usuario;
import com.salesianostriana.dam.proyectofinal.repository.UsuarioRepository;

@Service
public class UsuarioService extends BaseService<Usuario, Long, UsuarioRepository> {

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}
}
