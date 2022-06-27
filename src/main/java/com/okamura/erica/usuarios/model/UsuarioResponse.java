package com.okamura.erica.usuarios.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioResponse {
	
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	private String email;
	
	@JsonProperty
	private String nomeUsuario;
	
	@JsonProperty
	private String senha;
	
	@JsonProperty
	private String status;

	public UsuarioResponse() {
		
	}
	
	public UsuarioResponse(String nome, String email, String nomeUsuario, String senha, String status) {
		super();
		this.nome = nome;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
