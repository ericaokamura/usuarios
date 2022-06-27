package com.okamura.erica.usuarios.mapping;


import org.springframework.stereotype.Component;

import com.okamura.erica.usuarios.enums.StatusEnum;
import com.okamura.erica.usuarios.model.Usuario;
import com.okamura.erica.usuarios.model.UsuarioId;
import com.okamura.erica.usuarios.model.UsuarioIdRequest;
import com.okamura.erica.usuarios.model.UsuarioRequest;
import com.okamura.erica.usuarios.model.UsuarioResponse;
import com.okamura.erica.usuarios.model.dto.UsuarioDTO;


@Component
public class UsuarioMapping {
	
	
	public static UsuarioDTO fromModelToDTO(Usuario usuario) {
		
		
		UsuarioDTO dto = new UsuarioDTO();
		dto.setEmail(usuario.getId().getEmail());
		dto.setNome(usuario.getNome());
		dto.setNomeUsuario(usuario.getId().getNomeUsuario());
		
		return dto;
		
	}
	
	
	public static Usuario fromDTOToModel(UsuarioDTO dto) {
		
		Usuario usuario = new Usuario();
		usuario.setId(new UsuarioId(dto.getEmail(), dto.getNomeUsuario()));
		usuario.setNome(dto.getNome());
		
		return usuario;
		
	}
	
	
	public static UsuarioResponse fromModelToResponse(Usuario usuario) {
		
		
		UsuarioResponse response = new UsuarioResponse();
		response.setNome(usuario.getNome());
		response.setEmail(usuario.getId().getEmail());
		response.setNomeUsuario(usuario.getId().getNomeUsuario());
		response.setSenha(usuario.getSenha());
		response.setStatus(usuario.getStatus().toString());
		return response;
		
		
	}


	public static Usuario fromRequestToModel(UsuarioRequest usuario) {
		Usuario response = new Usuario();
		response.setNome(usuario.getNome());
		response.setId(new UsuarioId(usuario.getId().getEmail(), usuario.getId().getNomeUsuario()));
		response.setSenha(usuario.getSenha());
		response.setStatus(StatusEnum.valueOf(usuario.getStatus().toString()));
		return response;
	}

}
