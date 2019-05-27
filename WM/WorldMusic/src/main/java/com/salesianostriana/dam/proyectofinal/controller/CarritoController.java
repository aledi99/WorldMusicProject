package com.salesianostriana.dam.proyectofinal.controller;


/**Clase Controller del Carrito de la aplicación
 * @author alediaz
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.service.CarritoService;
import com.salesianostriana.dam.proyectofinal.service.ConciertoService;
import com.salesianostriana.dam.proyectofinal.service.ProductoService;



@Controller
public class CarritoController {
	

	@Autowired
	private CarritoService servicioCarrito;//Instancia de la clase CarritoService
	
	@Autowired
	private ProductoService servicioProducto;//Instancia de la clase ProductoService
	
	@Autowired
	private ConciertoService servicioConcierto;//Instancia de la clase ConciertoService
	
	/**
	 * Constructor con parámetros e inyección automática (Autowired)
	 * @param servicioCarrito
	 * @param servicioProducto
	 */
    @Autowired
    public CarritoController(CarritoService servicioCarrito, ProductoService servicioProducto) {
        this.servicioCarrito = servicioCarrito;
        this.servicioProducto = servicioProducto;
    }
    
    /**
     * Mostrar carrito
     * @param model
     * @return cart
     */
    @GetMapping ("/carrito")
    public String showCarrito (Model model) {
    	
    	if (model.addAttribute("productos",servicioCarrito.getProductsInCart()) == null)
    		return "redirect:/";
    	return "cart";
    }

    /**
     * Método que hace que un producto (escogido por su id) pase al carrito para finalizar la compra o seguir con esta
     * @param idProducto
     * @param model
     * @return redirect:/carrito
     */
    @GetMapping ("/productoACarrito/{id}")
    public String productoACarrito (@PathVariable("id") Long id, Model model) {
    	
    	servicioCarrito.addProducto(servicioProducto.findById(id));
    	    		 	
    	return "redirect:/carrito";
    }
    
    /**
     * Método que hace que un concierto (escogido por su id) pase al carrito para finalizar la compra o seguir con esta
     * @param id
     * @param model
     * @return redirect:/carrito
     */
    @GetMapping ("/conciertoACarrito/{id}")
    public String conciertoACarrito (@PathVariable("id") Long id, Model model) {
    	
    	servicioCarrito.addConcierto(servicioConcierto.findById(id));
    	    		 	
    	return "redirect:/carrito";
    }
    
    /**
     * Método el cual hace que borre un producto el cual se quiere comprar que está en el carrito
     * @param id
     * @return redirect:/carrito
     */
    @GetMapping("/borrarProductoC/{id}")
    public String removeProductFromCart(@PathVariable("id") Long id) {
        
    	servicioCarrito.removeProducto(servicioProducto.findById(id));
        return "redirect:/carrito";
    }
    
    /**
     * Método el cual hace que borre un concierto el cual se quiere comprar que está en el carrito
     * @param id
     * @return redirect:/carrito
     */
    @GetMapping("/borrarConciertoC/{id}")
    public String removeConciertoFromCart(@PathVariable("id") Long id) {
        
    	servicioCarrito.removeConcierto(servicioConcierto.findById(id));
        return "redirect:/carrito";
    }
    
    /**
     * Calcula el total del pvp de los productos seleccionados en el carrito
     * @return PvP total
     */
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
