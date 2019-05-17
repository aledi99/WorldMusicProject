package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.LineaPedidoModel;
import com.proyectofinal.repository.LineaPedidoRepository;

@Service
public class LineaPedidoServicio {

	private LineaPedidoRepository lineaPedidoRepository;

	public LineaPedidoServicio(LineaPedidoRepository repositorio) {
		this.lineaPedidoRepository = repositorio;
	}

	public LineaPedidoModel add(LineaPedidoModel c) {
		return lineaPedidoRepository.save(c);
	}

	public LineaPedidoModel edit(LineaPedidoModel c) {
		return lineaPedidoRepository.save(c);
	}

	public void delete(LineaPedidoModel c) {
		lineaPedidoRepository.delete(c);
	}

	public List<LineaPedidoModel> findAll() {
		return lineaPedidoRepository.findAll();
	}

	public LineaPedidoModel findById(long id) {
		return lineaPedidoRepository.findById(id).orElse(null);

	}

}
