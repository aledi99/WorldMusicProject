package com.salesianostriana.dam.proyectofinal.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;


import com.salesianostriana.dam.proyectofinal.model.Concierto;
import com.salesianostriana.dam.proyectofinal.model.Producto;
import com.salesianostriana.dam.proyectofinal.repository.ConciertoRepository;
import com.salesianostriana.dam.proyectofinal.repository.ProductoRepository;

@Service
@Scope (value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CarritoService {
	
private ProductoRepository productoRepository;
private ConciertoRepository conciertoRepository;
	
	private Map<Producto, Integer> producto = new HashMap <> ();
	private Map<Concierto, Integer> concierto = new HashMap <> ();
	
	@Autowired
	public CarritoService (ProductoRepository productorepository) {
		this.productoRepository=productorepository;
	}
	
	/**
	 * Si el producto ya está en el map (en el carrito), solo se incrementará en uno la cantidad, una unidad más
	 * Si el producto no está en el mapa, significa que no se ha comprado nada de él en este momento, por lo que se añade con cantidad 1
	 * 
	 * @param producto
	 * */
	
	public void addProducto (Producto p) {
		if (producto.containsKey(p)) {
			producto.replace(p, producto.get(p)+1);//Ya programamos como "mayores" y podemos poner algún número directamente en el código
		}else {
			producto.put(p, 1);
		}
	}
	
	/**
	 * Método que elimina un producto del carrito.
	 * Si en el carrito la cantidad de dicho producto es más de uno baja la cantidad en una unidad y si es uno elimina el producto entero
	 * @param producto
	 * */
	
	public void removeProducto (Producto p) {
        if (producto.containsKey(p)) {
            if (producto.get(p) > 1)
                producto.replace(p, producto.get(p) - 1);
            else if (producto.get(p) == 1) {
                producto.remove(p);
            }
        }
	}
	
	public void addConcierto(Concierto p) {
		if (concierto.containsKey(p)) {
			concierto.replace(p, concierto.get(p)+1);//Ya programamos como "mayores" y podemos poner algún número directamente en el código
		}else {
			concierto.put(p, 1);
		}
	}
	
	/**
	 * Método que elimina un producto del carrito.
	 * Si en el carrito la cantidad de dicho producto es más de uno baja la cantidad en una unidad y si es uno elimina el producto entero
	 * @param producto
	 * */
	
	public void removeConcierto (Concierto p) {
        if (concierto.containsKey(p)) {
            if (concierto.get(p) > 1)
            	concierto.replace(p, concierto.get(p) - 1);
            else if (concierto.get(p) == 1) {
            	concierto.remove(p);
            }
        }
	}
	
    /**
     * @return unmodifiable Copia del carrito no modificable, solo vista
     */
	

    public Map<Producto, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(producto);
    }
	
    /**
     * Se debería tener un método para revisar si hay suficiente cantidad de productos en el stock, no desarrollada en este ejemplo
     * puesto que no se gestiona ni el stock ni cantidad de producto es atributo de la clase POJO Producto,
     * esto debería estar gestionado en línea de pedido, pedido, etc.
     * Se debería tener una excepción propia (del estilo NotEnoughProductsInStockException) y gestionarlo
     */
 
    
    
    /**
     * El método para calcular el total de la compra podría ir aquí, multiplicando el precio de un producto
     * por la cantidad del mismo. Nosotros lo hemos hecho en el controller del carrito
     * 
     * */

}
