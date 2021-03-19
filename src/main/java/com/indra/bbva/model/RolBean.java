package com.indra.bbva.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class RolBean {
	@Id
	@Column(name = "NOMBREUSUARIO")
	private String nombreUsuario;

	@Column(name = "ROL")
	private String rol;

	public RolBean() {
	}

	public RolBean(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public RolBean(String nombreUsuario, String rol) {
		this.nombreUsuario = nombreUsuario;
		this.rol = rol;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "RolBean [nombreUsuario=" + nombreUsuario + ", rol=" + rol + "]";
	}
}
