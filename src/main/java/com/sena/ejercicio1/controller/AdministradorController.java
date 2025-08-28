package com.sena.ejercicio1.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ejercicio1.model.Producto;
import com.sena.ejercicio1.service.IProductoService;

//decir a la clase que es de tipo controlador 
@Controller
@RequestMapping("/Administrador") // solicitud de mapeo al directorio al administrador
public class AdministradorController {

	// instancia LOGGER
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;

	@GetMapping("")
	public String home(Model model) {
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "Administrador/home";
	}

}
