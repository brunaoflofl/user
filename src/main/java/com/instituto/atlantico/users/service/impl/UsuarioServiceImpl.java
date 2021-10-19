package com.instituto.atlantico.users.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.users.dao.UsuarioDao;
import com.instituto.atlantico.users.model.Usuario;
import com.instituto.atlantico.users.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
		return this.usuarioDao.cadastrarUsuario(usuario);
	}

	@Override
	public List listarUsuarios() throws Exception {
		return this.usuarioDao.listarUsuarios();
	}

	@Override
	public Usuario buscarPorId(Integer id) throws Exception {
		return this.usuarioDao.buscarPorId(id);

	}

	@Override
	public void deletarUsuario(Integer id) throws Exception {
		this.usuarioDao.deletarUsuario(id);
	}

	@Override
	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception {
		this.usuarioDao.atualizarUsuario(id, usersAtualizado);
	}

}
