package com.instituto.atlantico.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.instituto.atlantico.dao.UsuarioDao;
import com.instituto.atlantico.model.Usuario;

@Service
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private EntityManagerFactory em;

	@Override
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

	public List<Usuario> listarUsuarios() {
		EntityManager entityManager = em.createEntityManager();
		return entityManager.createQuery("FROM " + Usuario.class.getName()).getResultList();
	}

	@Override
	public Usuario buscarPorId(Integer id) throws Exception {

		EntityManager entityManager = em.createEntityManager();
		Usuario usuario = null;
		try {
			usuario = entityManager.find(Usuario.class, id);
		} finally {
			entityManager.close();
		}
		return usuario;
	}

	public void remove(Usuario usuario) {
		EntityManager entityManager = em.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getId());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	@Override
	public void deletarUsuario(Integer id) {
		try {
			Usuario usuario = buscarPorId(id);
			remove(usuario);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception {
		EntityManager entityManager = em.createEntityManager();
		Usuario user = buscarPorId(id);
		usersAtualizado.setId(user.getId());
		cadastrarUsuario(usersAtualizado);

	}

}
