package com.okamura.erica.usuarios.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okamura.erica.usuarios.enums.StatusEnum;
import com.okamura.erica.usuarios.exceptions.UsuarioExistenteException;
import com.okamura.erica.usuarios.exceptions.UsuarioNaoEncontradoException;
import com.okamura.erica.usuarios.mapping.UsuarioMapping;
import com.okamura.erica.usuarios.model.Usuario;
import com.okamura.erica.usuarios.model.UsuarioId;
import com.okamura.erica.usuarios.model.UsuarioRequest;
import com.okamura.erica.usuarios.model.UsuarioResponse;
import com.okamura.erica.usuarios.model.dto.UsuarioDTO;
import com.okamura.erica.usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository repository;
	

	public UsuarioResponse cadastraUsuario(UsuarioRequest usuario) throws UsuarioExistenteException {
		Optional<Usuario> retornoUsuario = repository.findById(new UsuarioId(usuario.getId().getEmail(), usuario.getId().getNomeUsuario()));
		if(!retornoUsuario.isPresent()) {
			return UsuarioMapping.fromModelToResponse(repository.save(UsuarioMapping.fromRequestToModel(usuario)));
		} else {
			throw new UsuarioExistenteException("usuário já existente");
		}
	}	
	
	public UsuarioDTO retornaUsuario(UsuarioRequest usuario) throws UsuarioNaoEncontradoException {
		Optional<Usuario> retornoUsuario = repository.findById(new UsuarioId(usuario.getId().getEmail(), usuario.getId().getNomeUsuario()));
		if(!retornoUsuario.isPresent()) {
			throw new UsuarioNaoEncontradoException();
		}
		return UsuarioMapping.fromModelToDTO(retornoUsuario.get());
	}
	
	public UsuarioResponse alteraUsuario(UsuarioRequest usuario) throws UsuarioNaoEncontradoException {
		Optional<Usuario> retornoUsuario = repository.findById(new UsuarioId(usuario.getId().getEmail(), usuario.getId().getNomeUsuario()));
		if(!retornoUsuario.isPresent()) {
			throw new UsuarioNaoEncontradoException();
		}
		return UsuarioMapping.fromModelToResponse(repository.save(UsuarioMapping.fromRequestToModel(usuario)));
	}
	
	public UsuarioResponse deletaUsuario(UsuarioRequest usuario) throws UsuarioNaoEncontradoException {
		Optional<Usuario> retornoUsuario = repository.findById(new UsuarioId(usuario.getId().getEmail(), usuario.getId().getNomeUsuario()));
		if(!retornoUsuario.isPresent()) {
			throw new UsuarioNaoEncontradoException();
		}
		Usuario usuarioRetorno = retornoUsuario.get();
		usuarioRetorno.setStatus(StatusEnum.DELETADO);
		return UsuarioMapping.fromModelToResponse(repository.save(usuarioRetorno));
		
		
	}

}
