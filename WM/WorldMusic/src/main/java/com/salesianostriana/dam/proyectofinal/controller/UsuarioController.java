package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
	
	@GetMapping("/hola")
	public String mostrar(Model model) {
		return "index";
	}

}
