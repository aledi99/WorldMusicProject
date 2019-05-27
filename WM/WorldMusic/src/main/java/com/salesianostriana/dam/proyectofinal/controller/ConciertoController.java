package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectofinal.model.Concierto;
import com.salesianostriana.dam.proyectofinal.model.Pager;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinal.service.ConciertoService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
public class ConciertoController {
	
	@Autowired
	private ConciertoService servicioConcierto;
	
	
	

	
	
	@GetMapping("/newConcierto")
	public String anyadirProducto(Model model) {
		model.addAttribute("concierto", new Concierto());
		
		return "RegisterConcierto";
	}
	
	@PostMapping("/newConcierto/submit")
	public String procesarFormulario(@ModelAttribute("concierto") Concierto a) {
		servicioConcierto.save(a);
		return "redirect:/listConcierto";
	}

	
	@GetMapping("/listConcierto")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaConcierto", servicioConcierto.findAll());
		return "ListaConciertos";
	}
	
	@GetMapping("/editarConcierto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Concierto editConcierto = servicioConcierto.findById(id);
		if (editConcierto != null) {
			model.addAttribute("concierto", editConcierto);
			return "RegisterConcierto";
		} else {
			return "redirect:/listConcierto";
		}
		
		
	}
	
	
	@PostMapping("/editarConcierto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("concierto") Concierto a) {
		servicioConcierto.edit(a);
		return "redirect:/listConcierto";
	}
	
	@GetMapping("/borrarConcierto/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioConcierto.deleteById(id);
		return "redirect:/listConcierto";
	}
	

}
