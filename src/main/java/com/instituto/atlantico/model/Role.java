package com.instituto.atlantico.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Collection<Usuario> usuario;

    public Role() {

    }

    public Role(String role){
        this.role = role;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<Usuario> getUsers() {
        return usuario;
    }

    public void setUsers(Collection<Usuario> usuario) {
        this.usuario = usuario;
    }
}