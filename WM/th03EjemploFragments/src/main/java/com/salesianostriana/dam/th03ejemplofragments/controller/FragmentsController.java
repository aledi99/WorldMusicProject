package com.salesianostriana.dam.th03ejemplofragments.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.th03ejemplofragments.model.Student;



@Controller
public class FragmentsController {

	
    @GetMapping("/index")
    public String getHome(Model model) {
    	model.addAttribute("persona",new Student ("Tú", "Sí sí, tú, ¡atiende!"));
        return "index.html";
    }
 
    @GetMapping("/fragments")
    public String markupPage() {
        return "fragments.html";
    }
 
}
