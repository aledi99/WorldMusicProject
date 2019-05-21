package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoriaController {
	
	@GetMapping("/categoria")
	public String producto(Model model) {
		return "Categoria";
	}

}
