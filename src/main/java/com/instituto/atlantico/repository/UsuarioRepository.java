package com.instituto.atlantico.repository;

import org.springframework.data.repository.CrudRepository;

import com.instituto.atlantico.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByUsername(String username);
}
