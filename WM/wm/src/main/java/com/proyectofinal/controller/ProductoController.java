package com.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.ProductoServicio;

@Controller
public class ProductoController {

	@Autowired
	private ProductoServicio productoService;

	public ProductoController(ProductoServicio servicio) {
		this.productoService = servicio;
	}

	@GetMapping({ "/", "/listProductos" })
	public String listarTodos(Model model) {
		model.addAttribute("listaProductos", productoService.findAll());
		return "index";
	}

}
