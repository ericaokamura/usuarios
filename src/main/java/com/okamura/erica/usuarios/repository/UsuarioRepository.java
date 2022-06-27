package com.okamura.erica.usuarios.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.okamura.erica.usuarios.model.Usuario;
import com.okamura.erica.usuarios.model.UsuarioId;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {
	
	Optional<Usuario> findById(UsuarioId id);
		
	Usuario save(Usuario usuario);
		

}
