package com.okamura.erica.usuarios.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioIdRequest {

	@JsonProperty
	private String email;
	
	@JsonProperty
	private String nomeUsuario;
	
	
	public UsuarioIdRequest() {
		
	}

	public UsuarioIdRequest(String email, String nomeUsuario) {
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
