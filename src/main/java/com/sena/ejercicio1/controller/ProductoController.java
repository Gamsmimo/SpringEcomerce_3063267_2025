package com.sena.ejercicio1.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.ejercicio1.model.Producto;
import com.sena.ejercicio1.model.Usuario;
import com.sena.ejercicio1.service.IProductoService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

	// instancia LOGGER
	private final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoservice;

//lista de productos
	@GetMapping("")
	public String show(Model model) {
		model.addAttribute("productos", productoservice.finAll());
		return "productos/show";
	}

// metodo de redireccionamiento al formulario de creacion de productos
	@GetMapping("/create")
	public String create() {
		return "productos/create";
	}

//metodo de creacion de productos
	@PostMapping("/save")
	public String save(Producto producto) {
		LOGGER.info("Este es el objeto del producto a guardar en la DB{}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoservice.save(producto);
		return "redirect:/productos";
	}

	// metodo para el formulario de edicon de productos
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Producto p = new Producto();
		// nos retorna la busqueda de un objeto de tipo producto con el id
		Optional<Producto> op = productoservice.get(id);
		p = op.get();
		LOGGER.warn("Busqueda de producto por id {}", p);
		model.addAttribute("producto", p);
		return "productos/edit";
	}

	@PostMapping("/update")
	// metodo de actualizacion de datos
	public String update(Producto producto) {
		LOGGER.info("Este es el objeto del producto a actualizar en la DB{}", producto);
		Usuario u = new Usuario(1, "", "", "", "", "", "", "", "");
		producto.setUsuario(u);
		productoservice.update(producto);
		return "redirect:/productos";
	}

	// metodo para elmininar con id un producto
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		productoservice.delete(id);
		return "redirect:/productos";
	}

}
