package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.Carrito;
import com.proyectofinal.repository.CarritoRepository;

@Service
public class CarritoServicio {

	private CarritoRepository carritoRepository;

	public CarritoServicio(CarritoRepository repositorio) {
		this.carritoRepository = repositorio;
	}

	public Carrito add(Carrito c) {
		return carritoRepository.save(c);
	}

	public Carrito edit(Carrito c) {
		return carritoRepository.save(c);
	}

	public void delete(Carrito c) {
		carritoRepository.delete(c);
	}

	public List<Carrito> findAll() {
		return carritoRepository.findAll();
	}

	public Carrito findById(long id) {
		return carritoRepository.findById(id).orElse(null);
	}

}
