package com.sena.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.sena.ejercicio1.model.Orden;
import com.sena.ejercicio1.model.Usuario;


public interface IOrdenService {

	public Orden save(Orden orden);

	public Optional<Orden> findById(Integer id);

	public List<Orden> finAll();
	
	public List<Orden> finByUsuario(Usuario usuario);
	
	public String generarNumeroOrden();

}
