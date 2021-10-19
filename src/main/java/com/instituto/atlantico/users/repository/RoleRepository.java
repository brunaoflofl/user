package com.instituto.atlantico.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.instituto.atlantico.users.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}