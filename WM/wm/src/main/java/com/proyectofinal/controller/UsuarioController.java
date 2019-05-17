package com.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.model.UsuarioModel;
import com.proyectofinal.service.UsuarioServicio;

@Controller
public class UsuarioController {

	
	private UsuarioServicio usuarioService;

	public UsuarioController(UsuarioServicio servicio) {
		this.usuarioService = servicio;
	}

	@GetMapping({ "/", "/listUsuarios" })
	public String listarTodos(Model model) {
		model.addAttribute("listaUsuarios", usuarioService.findAll());
		return "listaUsuarios";
	}
	
	@GetMapping("/nuevoUsuario")
	public String mostrarFormulario(Model model) {
		model.addAttribute("alumno", new UsuarioModel());
		return "Formulario";
	}

}
