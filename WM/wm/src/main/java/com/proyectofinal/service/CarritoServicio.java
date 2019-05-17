package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.CarritoModel;
import com.proyectofinal.repository.CarritoRepository;

@Service
public class CarritoServicio {

	private CarritoRepository carritoRepository;

	public CarritoServicio(CarritoRepository repositorio) {
		this.carritoRepository = repositorio;
	}

	public CarritoModel add(CarritoModel c) {
		return carritoRepository.save(c);
	}

	public CarritoModel edit(CarritoModel c) {
		return carritoRepository.save(c);
	}

	public void delete(CarritoModel c) {
		carritoRepository.delete(c);
	}

	public List<CarritoModel> findAll() {
		return carritoRepository.findAll();
	}

	public CarritoModel findById(long id) {
		return carritoRepository.findById(id).orElse(null);
	}

}
