package com.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.LineaPedidoServicio;

@Controller
public class LineaPedidoController {

	@Autowired
	private LineaPedidoServicio lineaPedidoService;

	public LineaPedidoController(LineaPedidoServicio servicio) {
		this.lineaPedidoService = servicio;
	}

	@GetMapping({ "/", "/listLineaPedido" })
	public String listarTodos(Model model) {
		model.addAttribute("listaLineaPedido", lineaPedidoService.findAll());
		return "index";
	}

}
