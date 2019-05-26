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
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService servicioProducto;
	
	@Autowired
	private ProductoRepository repositorioProducto;
	
	@GetMapping("/producto")
	public String producto(Model model) {
		return "Productos";
	}
	
	@GetMapping("/newProducto")
	public String anyadirProducto(Model model) {
		model.addAttribute("producto", new Producto());
		
		return "RegisterProducto";
	}
	
	@PostMapping("/newProducto/submit")
	public String procesarFormulario(@ModelAttribute("producto") Producto a) {
		servicioProducto.save(a);
		return "redirect:/";
	}

	
	@GetMapping("/listProducto")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaProducto", servicioProducto.findAll());
		return "ListaProductos";
	}
	
	@GetMapping("/editarProducto/{idProducto}")
	public String mostrarFormularioEdicion(@PathVariable("idProducto") long idProducto, Model model) {
		
		Producto editProducto = servicioProducto.findById(idProducto);
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
	
	@GetMapping("/borrarProducto/{idProducto}")
	public String borrar(@PathVariable("idProducto") long idProducto) {
		servicioProducto.deleteById(idProducto);
		return "redirect:/listProducto";
	}
	
	

}
