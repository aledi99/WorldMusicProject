package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Usuario editUsuario = servicioUsuario.findById(id);
		if (editUsuario != null) {
			model.addAttribute("usuarioEdit", editUsuario);
			return "Register";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/";
		}
		
		
	}
	
	
	@PostMapping("/newUsuario/submit")
	public String procesarFormulario(@ModelAttribute("usuario") Usuario a) {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		a.setContrasenya(p.encode(a.getContrasenya()));
		servicioUsuario.save(a);
		return "redirect:/";
	}

}
