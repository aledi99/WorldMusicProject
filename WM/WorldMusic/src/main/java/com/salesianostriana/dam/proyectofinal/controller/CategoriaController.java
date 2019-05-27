package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectofinal.model.Categoria;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService servicioCategoria;
	
	
	
	@GetMapping("/newCategoria")
	public String anyadirProducto(Model model) {
		model.addAttribute("categoria", new Categoria());
		
		return "RegisterCategoria";
	}
	
	@PostMapping("/newCategoria/submit")
	public String procesarFormulario(@ModelAttribute("categoria") Categoria a) {
		servicioCategoria.save(a);
		return "redirect:/listCategoria";
	}

	
	@GetMapping("/listCategoria")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaCategoria", servicioCategoria.findAll());
		return "ListaCategoria";
	}
	
	@GetMapping("/editarCategoria/{idCategoria}")
	public String mostrarFormularioEdicion(@PathVariable("idCategoria") long idCategoria, Model model) {
		
		Categoria editCategoria = servicioCategoria.findById(idCategoria);
		if (editCategoria != null) {
			model.addAttribute("producto", editCategoria);
			return "RegisterCategoria";
		} else {
			return "redirect:/listCategoria";
		}
		
		
	}
	
	@PostMapping("/editarCategoria/submit")
	public String procesarFormularioEdicion(@ModelAttribute("categoria") Categoria a) {
		servicioCategoria.edit(a);
		return "redirect:/listCategoria";
	}
	
	@GetMapping("/borrarCategoria/{idCategoria}")
	public String borrar(@PathVariable("idCategoria") long idCategoria) {
		servicioCategoria.deleteById(idCategoria);
		return "redirect:/listCategoria";
	}

}
