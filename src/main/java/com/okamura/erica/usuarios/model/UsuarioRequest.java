package com.okamura.erica.usuarios.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioRequest {

	@JsonProperty
	private String nome;
	
	@JsonProperty
	private UsuarioIdRequest id;

	@JsonProperty
	private String senha;
	
	@JsonProperty
	private String status;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioIdRequest getId() {
		return id;
	}

	public void setId(UsuarioIdRequest id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
