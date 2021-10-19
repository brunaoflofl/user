package com.instituto.atlantico.users.service;

import java.util.List;

import com.instituto.atlantico.users.model.Usuario;

public interface UsuarioService {

	public Usuario cadastrarUsuario(Usuario usuario) throws Exception;

	public List listarUsuarios() throws Exception;

	public Usuario buscarPorId(Integer id) throws Exception;

	public void deletarUsuario(Integer id) throws Exception;

	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception;

}
