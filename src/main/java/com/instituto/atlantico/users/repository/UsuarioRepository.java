package com.instituto.atlantico.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.instituto.atlantico.users.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByUsername(String username);
}
