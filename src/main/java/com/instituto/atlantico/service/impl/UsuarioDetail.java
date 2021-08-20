package com.instituto.atlantico.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.dao.UsuarioDao;
import com.instituto.atlantico.model.Usuario;
import com.instituto.atlantico.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioDetail implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioDetail(UsuarioDao usuarioDao) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = null;
		try {
			usuario = repository.findByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario não encontrado!");
		}
		return User.builder().username(usuario.getUsername()).password(usuario.getPassword()).roles("USER").build();
	}

}
