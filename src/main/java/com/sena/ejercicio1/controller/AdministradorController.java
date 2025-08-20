package com.sena.ejercicio1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//decir a la clase que es de tipo controlador 
@Controller
@RequestMapping("/Administrador") // solicitud de mapeo al directorio al administrador
public class AdministradorController {

	@GetMapping("")
	public String home() {
		return "Administrador/home";
	}

}
