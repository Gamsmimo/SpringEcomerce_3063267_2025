package com.sena.ejercicio1.service;

import java.util.List;
import java.util.Optional;

import com.sena.ejercicio1.model.Usuario;

public interface IUsuarioService {

	public Usuario save(Usuario usuario);

	public Optional<Usuario> get(Integer id);

	public void update(Usuario usuario);

	public void delete(Integer id);

	Optional<Usuario> finById(Integer id);

	Optional<Usuario> finByEmail(String Email);

	List<Usuario> finAll();

}
