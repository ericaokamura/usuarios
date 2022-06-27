package com.okamura.erica.usuarios.model.dto;

import java.io.Serializable;

public class ErrorDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String message;
	private Long status;
	
	
	public ErrorDTO() {
		
	}
	
	public ErrorDTO(String message, Long status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	
	
	

}
