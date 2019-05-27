package com.salesianostriana.dam.proyectofinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;

@Service
public class ProductoService extends BaseService<Producto, Long, ProductoRepository> {
	
	@Autowired
	private ProductoRepository repositorio;

	public Page<Producto> findAllPageable(Pageable pageable) {
		return repositorio.findAll(pageable);
	}

	public  Page<Producto> findByNombreContainingIgnoreCasePageable(String nombre, Pageable pageable)
	{
		return repositorio.findByNombreContainingIgnoreCase(nombre, pageable);
	}
	
	public  Page<Producto> findByNombreCategoriaContainingIgnoreCasePageable(String nombreCategoria, Pageable pageable)
	{
		return repositorio.findByNombreCategoriaContainingIgnoreCase(nombreCategoria, pageable);
	}
	
}
