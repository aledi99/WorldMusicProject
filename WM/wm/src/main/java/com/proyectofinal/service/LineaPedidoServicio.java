package com.proyectofinal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectofinal.model.Concierto;
import com.proyectofinal.model.LineaPedido;
import com.proyectofinal.repository.ConciertoRepository;
import com.proyectofinal.repository.LineaPedidoRepository;

@Service
public class LineaPedidoServicio {

	private LineaPedidoRepository lineaPedidoRepository;

	public LineaPedidoServicio(LineaPedidoRepository repositorio) {
		this.lineaPedidoRepository = repositorio;
	}

	public LineaPedido add(LineaPedido c) {
		return lineaPedidoRepository.save(c);
	}

	public LineaPedido edit(LineaPedido c) {
		return lineaPedidoRepository.save(c);
	}

	public void delete(LineaPedido c) {
		lineaPedidoRepository.delete(c);
	}

	public List<LineaPedido> findAll() {
		return lineaPedidoRepository.findAll();
	}

	public LineaPedido findById(long id) {
		return lineaPedidoRepository.findById(id).orElse(null);

	}

}