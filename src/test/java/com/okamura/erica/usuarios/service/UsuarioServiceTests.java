package com.okamura.erica.usuarios.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.okamura.erica.usuarios.enums.StatusEnum;
import com.okamura.erica.usuarios.exceptions.UsuarioExistenteException;
import com.okamura.erica.usuarios.exceptions.UsuarioNaoEncontradoException;
import com.okamura.erica.usuarios.model.Usuario;
import com.okamura.erica.usuarios.model.UsuarioId;
import com.okamura.erica.usuarios.model.UsuarioIdRequest;
import com.okamura.erica.usuarios.model.UsuarioRequest;
import com.okamura.erica.usuarios.model.UsuarioResponse;
import com.okamura.erica.usuarios.model.dto.UsuarioDTO;
import com.okamura.erica.usuarios.repository.UsuarioRepository;

@SpringBootTest
public class UsuarioServiceTests {

	@InjectMocks
	private UsuarioService service;

	@Mock
	private UsuarioRepository repository;

	UsuarioRequest usuarioRequest = new UsuarioRequest();

	UsuarioResponse usuarioResponse = new UsuarioResponse();

	UsuarioDTO usuarioDTO = new UsuarioDTO();
	
	Usuario usuario = new Usuario();

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
		
		usuario.setId(new UsuarioId("erica.okamura@yahoo.com.br", "ericaokamura"));
		usuario.setNome("Erica Okamura");
		usuario.setSenha("12345");
		usuario.setStatus(StatusEnum.ATIVO);
	}
	 
	@Test
	public void testa_cadastra_usuario_com_sucesso() throws UsuarioExistenteException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.ofNullable(null));
		when(repository.save(any(Usuario.class))).thenReturn(usuario);
		service.cadastraUsuario(usuarioRequest);
		assertEquals("ericaokamura", service.cadastraUsuario(usuarioRequest).getNomeUsuario());
	}
	
	@Test
	public void testa_cadastra_usuario_sem_sucesso_usuario_ja_existente() throws UsuarioExistenteException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.of(usuario));
		assertThrows(UsuarioExistenteException.class,() -> service.cadastraUsuario(usuarioRequest));
	}
	
	
	@Test
	public void testa_altera_usuario_com_sucesso() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.of(usuario));
		usuario.setNome("Erica Okamura Sato");
		when(repository.save(any(Usuario.class))).thenReturn(usuario);
		usuarioRequest.setNome("Erica Okamura Sato");
		service.alteraUsuario(usuarioRequest);
		assertEquals("Erica Okamura Sato", service.alteraUsuario(usuarioRequest).getNome());
	}
	
	@Test
	public void testa_altera_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.ofNullable(null));
		assertThrows(UsuarioNaoEncontradoException .class, () -> service.alteraUsuario(usuarioRequest));
	}
	
	@Test
	public void testa_retorna_usuario_com_sucesso() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.of(usuario));
		service.retornaUsuario(usuarioRequest);
	}
	
	@Test
	public void testa_retorna_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.ofNullable(null));
		assertThrows(UsuarioNaoEncontradoException.class,() -> service.retornaUsuario(usuarioRequest));
	}
	
	@Test
	public void testa_deleta_usuario_com_sucesso() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.of(usuario));
		when(repository.save(any(Usuario.class))).thenReturn(usuario);
		assertEquals("DELETADO", service.deletaUsuario(usuarioRequest).getStatus());
	}
	
	@Test
	public void testa_deleta_usuario_sem_sucesso_usuario_nao_encontrado() throws UsuarioNaoEncontradoException {
		when(repository.findById(any(UsuarioId.class))).thenReturn(Optional.ofNullable(null));
		assertThrows(UsuarioNaoEncontradoException.class, () -> service.deletaUsuario(usuarioRequest));
	}

}
