package com.salesianostriana.dam.proyectofinal.controller;

/**Clase Controller de los Conciertos
 * 
 * @author alediaz
 */


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.proyectofinal.model.Concierto;
import com.salesianostriana.dam.proyectofinal.service.ConciertoService;


@Controller
public class ConciertoController {
	
	@Autowired
	private ConciertoService servicioConcierto;//Instancia de la clase ConciertoService
	
	
	

	
	/**Crea un nuevo Concierto para después añadirlo
	 * 
	 * @param model
	 * @return RegisterConcierto
	 */
	@GetMapping("/newConcierto")
	public String anyadirProducto(Model model) {
		model.addAttribute("concierto", new Concierto());
		
		return "RegisterConcierto";
	}
	
	/**Guarda el Concierto creado
	 * 
	 * @param a
	 * @return redirect:/listConcierto
	 */
	@PostMapping("/newConcierto/submit")
	public String procesarFormulario(@ModelAttribute("concierto") Concierto a) {
		servicioConcierto.save(a);
		return "redirect:/listConcierto";
	}

	
	/**Muestra la tabla con la lista de Conciertos
	 * 
	 * @param model
	 * @return ListaConciertos
	 */
	@GetMapping("/listConcierto")
	public String mostrarProducto(Model model) {
		model.addAttribute("listaConcierto", servicioConcierto.findAll());
		return "ListaConciertos";
	}
	
	/**Muestra el Concierto en el formulario para editarlo, escogido mediante su id 
	 * 
	 * @param id
	 * @param model
	 * @return redirect:/listConcierto
	 */
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
	
	
	/**Edita el Concierto seleccionado 
	 * 
	 * @param a
	 * @return redirect:/listConcierto
	 */
	@PostMapping("/editarConcierto/submit")
	public String procesarFormularioEdicion(@ModelAttribute("concierto") Concierto a) {
		servicioConcierto.edit(a);
		return "redirect:/listConcierto";
	}
	
	/**Borra el Concierto seleccionado, escogido mediante su id
	 * 
	 * @param id
	 * @return redirect:/listConcierto
	 */
	@GetMapping("/borrarConcierto/{id}")
	public String borrar(@PathVariable("id") long id) {
		servicioConcierto.deleteById(id);
		return "redirect:/listConcierto";
	}
	

}
