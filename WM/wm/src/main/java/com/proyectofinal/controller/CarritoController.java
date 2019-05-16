package com.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.CarritoServicio;
import com.proyectofinal.service.CategoriaServicio;

@Controller
public class CarritoController {

	@Autowired
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
