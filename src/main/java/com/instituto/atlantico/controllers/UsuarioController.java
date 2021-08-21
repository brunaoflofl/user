package com.instituto.atlantico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.instituto.atlantico.model.Usuario;
import com.instituto.atlantico.service.UsuarioService;

@RestController
@RequestMapping("/api/users")
@EnableCaching
@CrossOrigin("http://localhost:8080")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvar(@RequestBody @Valid Usuario usuario) throws Exception {
		return this.usuarioService.cadastrarUsuario(usuario);
	}

	@GetMapping("/list")
	public List listarUsuarios() throws Exception {
		return usuarioService.listarUsuarios();
	}

	@GetMapping("/list/{id}")
	public Usuario findById(@PathVariable Integer id) throws Exception {
		return usuarioService.buscarPorId(id);

	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Integer id) throws Exception {
		this.usuarioService.deletarUsuario(id);
	}

	@PutMapping("/up/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateUsuario(@PathVariable Integer id, @RequestBody @Valid Usuario usersAtualizado) throws Exception {
		this.usuarioService.atualizarUsuario(id, usersAtualizado);
	}

}
