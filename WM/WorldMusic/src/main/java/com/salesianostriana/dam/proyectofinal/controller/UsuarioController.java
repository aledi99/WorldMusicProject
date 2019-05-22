package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Usuario;
import com.salesianostriana.dam.proyectofinal.repository.UsuarioRepository;
import com.salesianostriana.dam.proyectofinal.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService servicioUsuario;
	
	@Autowired
	private UsuarioRepository repositorioUsuario;
	
	@GetMapping({ "/", "/inicio"})
	public String mostrar(Model model) {
		return "Inicio";
	}
	
	@GetMapping("/login") 
	public String mostrarLogin(Model model) {
		return "Login";
	}
	
	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		return "Register";
	}
	
	@GetMapping("/ajustes")
	public String mostrarAjustes(Model model) {
		return "Ajustes";
	}
	
	@GetMapping("/newUsuario")
	public String anyadirUsuario(Model model) {
		
		model.addAttribute("usuario", new Usuario());
		
		return "Register";
		
	}
	
	@PostMapping("/newUsuario/submit")
	public String procesarFormulario(@ModelAttribute("usuario") Usuario a) {
		servicioUsuario.save(a);
		return "redirect:/";
	}

}
