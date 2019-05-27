package com.salesianostriana.dam.proyectofinal.controller;

/**Clase Controller de los Productos
 * @author alediaz
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.CategoriaService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoService servicioProducto;//Instancia de la clase ProductoService
	
	@Autowired
	private CategoriaService servicioCategoria;//Instancia de la clase CategoriaService
	
	/**
	 * Muestra la plantilla Productos
	 * @param model
	 * @return Productos
	 */
	@GetMapping("/producto")
	public String producto(Model model) {
		return "Productos";
	}
	
	/**
	 * Crea un nuevo Producto para después añadirlo
	 * @param model
	 * @return RegisterProducto
	 */
	@GetMapping("/newProducto")
	public String anyadirProducto(Model model) {
		model.addAttribute("producto", new Producto());
		model.addAttribute("listaCategoria", servicioCategoria.findAll());
		
		return "RegisterProducto";
	}
	
	/**
	 * Añade el Producto creado
	 * @param a
	 * @return redirect:/listProducto
	 */
	@PostMapping("/newProducto/submit")
	public String procesarFormulario(@ModelAttribute("producto") Producto a) {
		servicioProducto.save(a);
		return "redirect:/listProducto";
	}

	/**
	 * Muestra una tabla con la lista de Productos
	 * @param model
	 * @return ListaProductos
	 */
	@GetMapping("/listProducto")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaProducto", servicioProducto.findAll());
		return "ListaProductos";
	}
	
	/**
	 * Selecciona un Producto mediante su id para editarlo en su correspondiente formulario
	 * @param id
	 * @param model
	 * @return
	 */
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
	
	/**
	 * Edita el Producto seleccionado
	 * @param a
	 * @return redirect:/listProducto
	 */
	@PostMapping("/editarProducto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("producto") Producto a) {
		servicioProducto.edit(a);
		return "redirect:/listProducto";
	}
	
	/**
	 * Borra el Producto seleccionado mediante su id
	 * @param id
	 * @return redirect:/listProducto
	 */
	@GetMapping("/borrarProducto/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioProducto.deleteById(id);
		return "redirect:/listProducto";
	}
	
	

}
