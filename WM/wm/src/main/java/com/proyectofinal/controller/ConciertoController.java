package com.proyectofinal.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.ConciertoServicio;

@Controller
public class ConciertoController {

	
	private ConciertoServicio conciertoService;

	public ConciertoController(ConciertoServicio servicio) {
		this.conciertoService = servicio;
	}

	@GetMapping({ "/", "/listConcierto" })
	public String listarTodos(Model model) {
		model.addAttribute("listaConcierto", conciertoService.findAll());
		return "index";
	}

}
