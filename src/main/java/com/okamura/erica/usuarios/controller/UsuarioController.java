package com.okamura.erica.usuarios.controller;

import org.springframework.web.bind.annotation.RestController;

import com.okamura.erica.usuarios.exceptions.UsuarioExistenteException;
import com.okamura.erica.usuarios.exceptions.UsuarioNaoEncontradoException;
import com.okamura.erica.usuarios.model.Usuario;
import com.okamura.erica.usuarios.model.UsuarioRequest;
import com.okamura.erica.usuarios.model.UsuarioResponse;
import com.okamura.erica.usuarios.model.dto.ErrorDTO;
import com.okamura.erica.usuarios.model.dto.UsuarioDTO;
import com.okamura.erica.usuarios.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService service;

	@RequestMapping(value="/usuarios",method=RequestMethod.POST)
	public ResponseEntity cadastraUsuario(@RequestBody UsuarioRequest usuario) {
		UsuarioResponse retornoUsuario = new UsuarioResponse();
		try {
			retornoUsuario = service.cadastraUsuario(usuario);
			return ResponseEntity.ok(retornoUsuario);
		} catch (UsuarioExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("usuário já existente, não foi possível cadastrar.",400L));
		}		
		
	}
	
	@RequestMapping(value="/usuarios",method=RequestMethod.DELETE)
	public ResponseEntity deletaUsuario(@RequestBody UsuarioRequest usuario) {
		UsuarioResponse retornoUsuario = new UsuarioResponse();
		try {
			retornoUsuario = service.deletaUsuario(usuario);
			return ResponseEntity.ok(retornoUsuario);
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("usuário não existente.",400L));
		}		
		
	}
	
	@RequestMapping(value="/usuarios",method=RequestMethod.GET)
	public ResponseEntity retornaUsuario(@RequestBody UsuarioRequest usuario) {
		UsuarioDTO retornoDTO = new UsuarioDTO();
		try {
			retornoDTO = service.retornaUsuario(usuario);
			return ResponseEntity.ok(retornoDTO);
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("usuário não existente.",400L));
		}		
		
	}
	
	@RequestMapping(value="/usuarios",method=RequestMethod.PUT)
	public ResponseEntity alteraUsuario(@RequestBody UsuarioRequest usuario) {
		UsuarioResponse retornoUsuario = new UsuarioResponse();
		try {
			retornoUsuario = service.alteraUsuario(usuario);
			return ResponseEntity.ok(retornoUsuario);
		} catch (UsuarioNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorDTO("usuário não existente.",400L));
		}		
		
	}
	
}
