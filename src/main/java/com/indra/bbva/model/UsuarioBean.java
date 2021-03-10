package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class UsuarioBean {
	@Id
	@Column(name = "NOMBREUSUARIO")
	private String nombreUsuario;

	@Column(name = "CLAVE")
	private String clave;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEFONO")
	private String telefono;

	@Column(name = "ACTIVO")
	private Integer activo;

	public UsuarioBean() {
	}

	public UsuarioBean(String nombreUsuario, String clave, String email, String telefono) {
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.email = email;
		this.telefono = telefono;
	}

	public UsuarioBean(String nombreUsuario, String clave, String email, String telefono, Integer activo) {
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.email = email;
		this.telefono = telefono;
		this.activo = activo;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "UserBean [nombreUsuario=" + nombreUsuario + ", clave=" + clave + ", email=" + email + ", telefono="
				+ telefono + ", activo=" + activo + "]";
	}

}
