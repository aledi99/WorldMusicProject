package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.CategoriaModel;
import com.proyectofinal.repository.CategoriaRepository;

@Service
public class CategoriaServicio {
	
	private CategoriaRepository categoriaRepository;
	
	
	public CategoriaServicio(CategoriaRepository repositorio) {
		this.categoriaRepository = repositorio;
	}
	
	
	public CategoriaModel add(CategoriaModel c) {
		return categoriaRepository.save(c);
	}

	public CategoriaModel edit(CategoriaModel c) {
		return categoriaRepository.save(c);
	}

	public void delete(CategoriaModel c) {
		categoriaRepository.delete(c);
	}

	public List<CategoriaModel> findAll() {
		return categoriaRepository.findAll();
	}

	public CategoriaModel findById(long id) {
		return categoriaRepository.findById(id).orElse(null);

}
	
}
