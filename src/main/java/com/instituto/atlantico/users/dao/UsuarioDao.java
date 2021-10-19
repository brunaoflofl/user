package com.instituto.atlantico.users.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.users.dao.UsuarioDao;
import com.instituto.atlantico.users.model.Usuario;

@Service
@Transactional
public class UsuarioDao {

	@Autowired
	private EntityManagerFactory em;

	public Usuario cadastrarUsuario(Usuario usuario) throws Exception {

		EntityManager entityManager = em.createEntityManager();

		try {

			entityManager.getTransaction().begin();

			if (usuario.getUsername() == null) {
				entityManager.persist(usuario);
			} else {
				usuario = entityManager.merge(usuario);
			}
			entityManager.getTransaction().commit();
		} finally {
			entityManager.close();
		}
		return usuario;

	}

	public List<Usuario> listarUsuarios() throws Exception {

		EntityManager entityManager = em.createEntityManager();

		return entityManager.createQuery("from " + Usuario.class.getName()).getResultList();
	}

	public Usuario buscarPorId(Integer id) throws Exception {

		EntityManager entityManager = em.createEntityManager();

		Query query = entityManager.createQuery("from Usuario u where u.id=:id");
		query.setParameter("id", id);
		return (Usuario) query.getSingleResult();
	}

	public void deletarUsuario(Integer id) throws Exception {

		EntityManager entityManager = em.createEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("delete from Usuario u where u.id=:id").setParameter("id", id);
		int rowsDeleted = query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception {

		EntityManager entityManager = em.createEntityManager();

		Usuario user = buscarPorId(id);
		usersAtualizado.setId(user.getId());
		cadastrarUsuario(usersAtualizado);

	}

}
