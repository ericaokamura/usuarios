package com.okamura.erica.usuarios.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import com.okamura.erica.usuarios.enums.StatusEnum;


@Entity
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	
	@EmbeddedId
	private UsuarioId id;


	@Size(min=6)
	private String senha;
	
	private StatusEnum status = StatusEnum.ATIVO;


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UsuarioId getId() {
		return id;
	}

	public void setId(UsuarioId id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	} 
	
	
	

}
