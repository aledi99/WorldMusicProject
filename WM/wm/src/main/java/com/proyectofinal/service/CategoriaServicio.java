package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.Carrito;
import com.proyectofinal.model.Categoria;
import com.proyectofinal.repository.CategoriaRepository;

@Service
public class CategoriaServicio {
	
	private CategoriaRepository categoriaRepository;
	
	
	public CategoriaServicio(CategoriaRepository repositorio) {
		this.categoriaRepository = repositorio;
	}
	
	
	public Categoria add(Categoria c) {
		return categoriaRepository.save(c);
	}

	public Categoria edit(Categoria c) {
		return categoriaRepository.save(c);
	}

	public void delete(Categoria c) {
		categoriaRepository.delete(c);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria findById(long id) {
		return categoriaRepository.findById(id).orElse(null);

}
	
}
