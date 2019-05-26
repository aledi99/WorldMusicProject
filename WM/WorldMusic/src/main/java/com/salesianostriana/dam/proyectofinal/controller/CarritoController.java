package com.salesianostriana.dam.proyectofinal.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.CarritoService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;



@Controller
public class CarritoController {
	

	@Autowired
	private CarritoService servicioCarrito;
	
	@Autowired
	private ProductoService servicioProducto;
	
    @Autowired
    public CarritoController(CarritoService servicioCarrito, ProductoService servicioProducto) {
        this.servicioCarrito = servicioCarrito;
        this.servicioProducto = servicioProducto;
    }
    
    @GetMapping ("/carrito")
    public String showCarrito (Model model) {
    	
    	if (model.addAttribute("producto",servicioCarrito.getProductsInCart()) == null)
    		return "redirect:/";
    	return "cart";
    }

    @GetMapping ("/productoACarrito/{idProducto}")
    public String productoACarrito (@PathVariable("idProducto") Long idProducto, Model model) {
    	
    	servicioCarrito.addProducto(servicioProducto.findById(idProducto));
    	    		 	
    	return "redirect:/carrito";
    }
    
    @GetMapping("/borrarProductoC/{idProducto}")
    public String removeProductFromCart(@PathVariable("idProducto") Long idProducto) {
        
    	servicioCarrito.removeProducto(servicioProducto.findById(idProducto));
        return "redirect:/carrito";
    }
    
    @ModelAttribute("total_carrito")
    public Double totalCarrito () {
    	
    	Map <Producto,Integer> carrito=servicioCarrito.getProductsInCart();
    	double total=0.0;
    	if (carrito !=null) {
        	for (Producto p: carrito.keySet()) {
        		total+=p.getPvp()*carrito.get(p);
        	}
        	return total;
    	}
    	
    	return 0.0;
    }

}
