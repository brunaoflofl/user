package com.instituto.atlantico.users.dataloader;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.instituto.atlantico.users.model.Role;
import com.instituto.atlantico.users.model.Usuario;
import com.instituto.atlantico.users.repository.RoleRepository;
import com.instituto.atlantico.users.repository.UsuarioRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	LocalDate dt1 = LocalDate.parse("15/03/1990", formatter);
	
    @Override
    public void run(String... args) throws Exception {
    	
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");
        
        Usuario usuario = new Usuario("test@test.com", "123", "TestAdmin", dt1, true, "admin");
        usuario.setRoles(Arrays.asList(adminRole));
        usuarioRepository.save(usuario);

        usuario = new Usuario("test@test.com", "123", "TestUsuario", dt1, true, "user");
        usuario.setRoles(Arrays.asList(userRole));
        usuarioRepository.save(usuario);

    }


}
