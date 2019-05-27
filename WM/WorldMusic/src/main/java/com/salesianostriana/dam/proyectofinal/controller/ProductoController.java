package com.salesianostriana.dam.proyectofinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService servicioProducto;
	
	@Autowired
	private CategoriaService servicioCategoria;
	
	@Autowired
	private ProductoRepository repositorioProducto;
	
	@GetMapping("/producto")
	public String producto(Model model) {
		return "Productos";
	}
	
	@GetMapping("/newProducto")
	public String anyadirProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("listaCategoria", servicioCategoria.findAll());
		
		return "RegisterProducto";
	}
	
	@PostMapping("/newProducto/submit")
	public String procesarFormulario(@ModelAttribute("producto") Producto a) {
		servicioProducto.save(a);
		return "redirect:/listProducto";
	}

	
	@GetMapping("/listProducto")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaProducto", servicioProducto.findAll());
		return "ListaProductos";
	}
	
	@GetMapping("/editarProducto/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		Producto editProducto = servicioProducto.findById(id);
		if (editProducto != null) {
			model.addAttribute("producto", editProducto);
			return "RegisterProducto";
		} else {
			return "redirect:/listProducto";
		}
		
		
	}
	
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Producto a) {
		servicioProducto.edit(a);
		return "redirect:/listProducto";
	}
	
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioProducto.deleteById(id);
		return "redirect:/listProducto";
	}
	
	

}
