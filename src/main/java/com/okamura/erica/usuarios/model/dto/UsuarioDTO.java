package com.okamura.erica.usuarios.model.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	private String email;
	
	private String nomeUsuario;
	

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

}