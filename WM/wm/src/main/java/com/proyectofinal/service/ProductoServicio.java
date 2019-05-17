package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.ProductoModel;
import com.proyectofinal.repository.ProductoRepository;

@Service
public class ProductoServicio {

	private ProductoRepository productoRepository;

	public ProductoServicio(ProductoRepository repositorio) {
		this.productoRepository = repositorio;
	}

	public ProductoModel add(ProductoModel c) {
		return productoRepository.save(c);
	}

	public ProductoModel edit(ProductoModel c) {
		return productoRepository.save(c);
	}

	public void delete(ProductoModel c) {
		productoRepository.delete(c);
	}

	public List<ProductoModel> findAll() {
		return productoRepository.findAll();
	}

	public ProductoModel findById(long id) {
		return productoRepository.findById(id).orElse(null);

	}
}
