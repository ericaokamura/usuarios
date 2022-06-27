package com.okamura.erica.usuarios.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.okamura.erica.usuarios.exceptions.UsuarioExistenteException;
import com.okamura.erica.usuarios.exceptions.UsuarioNaoEncontradoException;
import com.okamura.erica.usuarios.model.UsuarioIdRequest;
import com.okamura.erica.usuarios.model.UsuarioRequest;
import com.okamura.erica.usuarios.model.UsuarioResponse;
import com.okamura.erica.usuarios.model.dto.UsuarioDTO;
import com.okamura.erica.usuarios.service.UsuarioService;

@SpringBootTest
public class UsuarioControllerTests {
	
	@InjectMocks
	private UsuarioController controller;
	
	@Mock
	private UsuarioService service;
	
	UsuarioRequest usuarioRequest = new UsuarioRequest();
	
	UsuarioResponse usuarioResponse = new UsuarioResponse();
	
	UsuarioDTO usuarioDTO = new UsuarioDTO();

	
	
	@BeforeEach
	public void setup() {
		usuarioRequest.setNome("Erica Okamura");
		usuarioRequest.setSenha("12345");
		usuarioRequest.setStatus("ATIVO");
		usuarioRequest.setId(new UsuarioIdRequest("erica.okamura@yahoo.com.br","ericaokamura"));
		
		usuarioResponse.setEmail("erica.okamura@yahoo.com.br");
		usuarioResponse.setNome("Erica Okamura");
		usuarioResponse.setNomeUsuario("ericaokamura");
		usuarioResponse.setSenha("12345");
		usuarioResponse.setStatus("ATIVO");
		
		usuarioDTO.setEmail("erica.okamura@yahoo.com.br");
		usuarioDTO.setNome("Erica Okamura");
		usuarioDTO.setNomeUsuario("ericaokamura");
	}
	
	@Test
	public void testa_cadastra_usuario_com_sucesso() throws UsuarioExistenteException {	
		when(service.cadastraUsuario(any(UsuarioRequest.class))).thenReturn(usuarioResponse);
		controller.cadastraUsuario(usuarioRequest);
		
	}
	
	@Test
	public void testa_cadastra_usuario_sem_sucesso_usuario_ja_existente() throws UsuarioExistenteException {	
		when(service.cadastraUsuario(any(UsuarioRequest.class))).thenThrow(UsuarioExistenteException.class);
		controller.cadastraUsuario(usuarioRequest);	
	}
	
	@Test
	public void testa_altera_usuario_com_sucesso() throws UsuarioNaoEncontradoException {	
		when(service.alteraUsuario(any(UsuarioRequest.class))).thenReturn(usuarioResponse);
		controller.alteraUsuario(usuarioRequest);	
	}
	
	@Test
	public void testa_altera_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {	
		when(service.alteraUsuario(any(UsuarioRequest.class))).thenThrow(UsuarioNaoEncontradoException.class);
		controller.alteraUsuario(usuarioRequest);	
	}
	
	@Test
	public void testa_retorna_usuario_com_sucesso() throws UsuarioNaoEncontradoException {	
		when(service.retornaUsuario(any(UsuarioRequest.class))).thenReturn(usuarioDTO);
		controller.retornaUsuario(usuarioRequest);	
	}
	
	@Test
	public void testa_retorna_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {	
		when(service.retornaUsuario(any(UsuarioRequest.class))).thenThrow(UsuarioNaoEncontradoException.class);
		controller.retornaUsuario(usuarioRequest);	
	}
	
	@Test
	public void testa_deleta_usuario_com_sucesso() throws UsuarioNaoEncontradoException {	
		when(service.deletaUsuario(any(UsuarioRequest.class))).thenReturn(usuarioResponse);
		controller.deletaUsuario(usuarioRequest);
	}
	
	@Test
	public void testa_deleta_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {	
		when(service.deletaUsuario(any(UsuarioRequest.class))).thenThrow(UsuarioNaoEncontradoException.class);
		controller.deletaUsuario(usuarioRequest);
	}
	
	
}
