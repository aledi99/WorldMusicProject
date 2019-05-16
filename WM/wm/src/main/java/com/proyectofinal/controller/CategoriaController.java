package com.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyectofinal.service.CategoriaServicio;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaServicio categoriaService;

	public CategoriaController(CategoriaServicio servicio) {
		this.categoriaService = servicio;
	}

	@GetMapping({ "/", "/listCategoria" })
	public String listarTodos(Model model) {
		model.addAttribute("listaCategoria", categoriaService.findAll());
		return "index";
	}

}