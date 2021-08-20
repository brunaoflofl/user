package com.instituto.atlantico.DaoImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.dao.RoleDao;
import com.instituto.atlantico.model.Role;
import com.instituto.atlantico.model.Usuario;

@Service
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private EntityManagerFactory em;

	@Override
	public String buscarPorRole(String role) throws Exception {

		EntityManager entityManager = em.createEntityManager();
		Role usuario = null;
		try {
			usuario = entityManager.find(Role.class, role);
		} finally {
			entityManager.close();
		}
		return role;
	}

}
