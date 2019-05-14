package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.Producto;
import com.proyectofinal.model.Usuario;
import com.proyectofinal.repository.ProductoRepository;
import com.proyectofinal.repository.UsuarioRepository;

@Service
public class UsuarioServicio {

	private UsuarioRepository usuarioRepository;

	public UsuarioServicio(UsuarioRepository repositorio) {
		this.usuarioRepository = repositorio;
	}

	public Usuario add(Usuario c) {
		return usuarioRepository.save(c);
	}

	public Usuario edit(Usuario c) {
		return usuarioRepository.save(c);
	}

	public void delete(Usuario c) {
		usuarioRepository.delete(c);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(long id) {
		return usuarioRepository.findById(id).orElse(null);

	}
	
}
