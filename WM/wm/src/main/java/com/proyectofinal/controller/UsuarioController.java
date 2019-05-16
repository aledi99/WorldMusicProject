package com.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.UsuarioServicio;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioServicio usuarioService;

	public UsuarioController(UsuarioServicio servicio) {
		this.usuarioService = servicio;
	}

	@GetMapping({ "/", "/listUsuarios" })
	public String listarTodos(Model model) {
		model.addAttribute("listaUsuarios", usuarioService.findAll());
		return "listaUsuarios";
	}

}
