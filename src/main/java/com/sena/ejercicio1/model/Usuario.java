package com.sena.ejercicio1.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//anotation jpa

@Entity
@Table (name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	private String documento;
	private String telefono;
	private String password;
	private String direccion;
	private String tipo;

	@OneToMany(mappedBy = "usuario")
	private List<Producto> productos;
	@OneToMany(mappedBy = "usuario")
	private List<Orden> ordenes;

//constructor vacio o sin campos
	public Usuario() {
		super();
	}

	// constructor con campos
	public Usuario(Integer id, String nombre, String email, String documento, String telefono, String password,
			String direccion, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.documento = documento;
		this.telefono = telefono;
		this.password = password;
		this.direccion = direccion;
		this.tipo = tipo;
	}

//geters and seters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", documento=" + documento
				+ ", telefono=" + telefono + ", password=" + password + ", direccion=" + direccion + ", tipo=" + tipo
				+ "]";
	}

}