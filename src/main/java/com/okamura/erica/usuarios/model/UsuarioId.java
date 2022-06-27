package com.okamura.erica.usuarios.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UsuarioId implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String email;
	
	private String nomeUsuario;
	
	
	public UsuarioId() {
		
	}

	public UsuarioId(String email, String nomeUsuario) {
		super();
		this.email = email;
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	

}
