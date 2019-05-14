package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.LineaPedido;
import com.proyectofinal.model.Producto;
import com.proyectofinal.repository.LineaPedidoRepository;
import com.proyectofinal.repository.ProductoRepository;

@Service
public class ProductoServicio {

	private ProductoRepository productoRepository;

	public ProductoServicio(ProductoRepository repositorio) {
		this.productoRepository = repositorio;
	}

	public Producto add(Producto c) {
		return productoRepository.save(c);
	}

	public Producto edit(Producto c) {
		return productoRepository.save(c);
	}

	public void delete(Producto c) {
		productoRepository.delete(c);
	}

	public List<Producto> findAll() {
		return productoRepository.findAll();
	}

	public Producto findById(long id) {
		return productoRepository.findById(id).orElse(null);

	}
}
