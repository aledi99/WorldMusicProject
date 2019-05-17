package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.UsuarioModel;
import com.proyectofinal.repository.UsuarioRepository;

@Service
public class UsuarioServicio {

	private UsuarioRepository usuarioRepository;

	public UsuarioServicio(UsuarioRepository repositorio) {
		this.usuarioRepository = repositorio;
	}

	public UsuarioModel add(UsuarioModel c) {
		return usuarioRepository.save(c);
	}

	public UsuarioModel edit(UsuarioModel c) {
		return usuarioRepository.save(c);
	}

	public void delete(UsuarioModel c) {
		usuarioRepository.delete(c);
	}

	public List<UsuarioModel> findAll() {
		return usuarioRepository.findAll();
	}

	public UsuarioModel findById(long id) {
		return usuarioRepository.findById(id).orElse(null);

	}
	
}
