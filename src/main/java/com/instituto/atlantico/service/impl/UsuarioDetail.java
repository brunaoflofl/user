package com.instituto.atlantico.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.model.Role;
import com.instituto.atlantico.model.Usuario;
import com.instituto.atlantico.repository.UsuarioRepository;

@Transactional
@Service
public class UsuarioDetail implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioDetail(UsuarioRepository repository) {
		this.repository = repository;
	}


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = repository.findByUsername(username);
            if(usuario==null){
                return null;
            }
            return new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), getAuthories(usuario));
        }

        catch (Exception e)
        {
         throw new UsernameNotFoundException("User not found!");
        }
    }
    private Set<GrantedAuthority> getAuthories(Usuario usuario){

        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role: usuario.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }


}
