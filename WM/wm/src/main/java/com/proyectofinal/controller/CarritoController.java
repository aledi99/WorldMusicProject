package com.proyectofinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.CarritoServicio;


@Controller
public class CarritoController {

	
	private CarritoServicio carritoService;

	public CarritoController(CarritoServicio servicio) {
		this.carritoService = servicio;
	}

	@GetMapping({ "/", "/listCarrito" })
	public String listarTodos(Model model) {
		model.addAttribute("listaCarrito", carritoService.findAll());
		return "index";
	}

}
