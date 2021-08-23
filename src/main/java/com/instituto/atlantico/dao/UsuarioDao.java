package com.instituto.atlantico.dao;

import java.util.List;

import com.instituto.atlantico.model.Usuario;

public interface UsuarioDao {
	
	public Usuario cadastrarUsuario(Usuario usuario) throws Exception;

	public List listarUsuarios() throws Exception;

	public List buscarPorId(Integer id) throws Exception;

	public void deletarUsuario(Integer id) throws Exception;

	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception;

}
