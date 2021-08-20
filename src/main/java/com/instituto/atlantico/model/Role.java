package com.instituto.atlantico.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String role;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Collection<Usuario> usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Collection<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(Collection<Usuario> usuario) {
		this.usuario = usuario;
	}

	public Role(Integer id, String role, Collection<Usuario> usuario) {
		super();
		this.id = id;
		this.role = role;
		this.usuario = usuario;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

}
