package com.salesianostriana.dam.proyectofinal.controller;

/**Clase Controller de los Usuarios
 * @author alediaz
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.model.Usuario;
import com.salesianostriana.dam.proyectofinal.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService servicioUsuario;//Instancia de la clase UsuarioService
	
	/**
	 * Muestra la plantilla Inicio
	 * @param model
	 * @return Inicio
	 */
	@GetMapping({ "/", "/inicio"})
	public String mostrar(Model model) {
		return "Inicio";
	}
	
	/**
	 * Muestra la plantilla World Music
	 * @param model
	 * @return World Music
	 */
	@GetMapping({"/acerca"})
	public String acercaDe(Model model) {
		return "World Music";
	}
	
	/**
	 * Muestra la plantilla Login
	 * @param model
	 * @return Login
	 */
	@GetMapping("/login") 
	public String mostrarLogin(Model model) {
		return "Login";
	}
	
	/**
	 * Crea un nuevo Usuario para después añadirlo (desde Inicio)
	 * @param model
	 * @return Register
	 */
	@GetMapping("/registro")
	public String mostrarRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "Register";
	}
	
	@PostMapping("/registro/submit")
	public String procesarFormularioRegistro(@ModelAttribute("usuario") Usuario a) {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		a.setContrasenya(p.encode(a.getContrasenya()));
		servicioUsuario.save(a);
		return "redirect:/";
	}
	
	
	/**
	 * Muestra la plantilla Ajustes
	 * @param model
	 * @return Ajustes
	 */
	@GetMapping("/ajustes")
	public String mostrarAjustes(Model model) {
		return "Ajustes";
	}
	
	/**
	 * Crea un nuevo Usuario para después añadirlo (desde ListaUsuario)
	 * @param model
	 * @return Register
	 */
	@GetMapping("/newUsuario")
	public String anyadirUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "Register";
		
	}
	
	/**
	 * Muestra una tabla con la lista de Usuarios
	 * @param model
	 * @return ListaUsuario
	 */
	@GetMapping("/listUsuario")
	public String mostrarUsuario(Model model) {
		
		model.addAttribute("listaUsuario", servicioUsuario.findAll());
		
		return "ListaUsuario";
	}
	
	/**
	 * Selecciona un Usuario mediante su id para ser editado
	 * @param idUsuario
	 * @param model
	 * @return Register
	 */
	@GetMapping("/editarUsuario/{idUsuario}")
	public String mostrarFormularioEdicion(@PathVariable("idUsuario") long idUsuario, Model model) {
		
		Usuario editUsuario = servicioUsuario.findById(idUsuario);
		if (editUsuario != null) {
			model.addAttribute("usuario", editUsuario);
			return "Register";
		} else {
			// No existe ningún alumno con el Id proporcionado.
			// Redirigimos hacia el listado.
			return "redirect:/listUsuario";
		}
		
		
	}
	
	/**
	 * Edita el Usuario seleccionado anteriormente
	 * @param a
	 * @return redirect:/listUsuario
	 */
	@PostMapping("/editarUsuario/submit")
	public String procesarFormularioEdicion(@ModelAttribute("usuario") Usuario a) {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		a.setContrasenya(p.encode(a.getContrasenya()));
		servicioUsuario.edit(a);
		return "redirect:/listUsuario";
	}
	
	/**
	 * Selecciona un Usuario para borrarlo
	 * @param idUsuario
	 * @return redirect:/listUsuario
	 */
	@GetMapping("/borrarUsuario/{idUsuario}")
	public String borrar(@PathVariable("idUsuario") long idUsuario) {
		servicioUsuario.deleteById(idUsuario);
		return "redirect:/listUsuario";
	}
	
	/**
	 * Añade el Usuario creado
	 * @param a
	 * @return redirect:/listUsuario
	 */
	@PostMapping("/newUsuario/submit")
	public String procesarFormulario(@ModelAttribute("usuario") Usuario a) {
		BCryptPasswordEncoder p = new BCryptPasswordEncoder();
		a.setContrasenya(p.encode(a.getContrasenya()));
		servicioUsuario.save(a);
		return "redirect:/listUsuario";
	}
	

}
