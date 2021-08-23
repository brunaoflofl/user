package com.instituto.atlantico.DaoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

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
	@Override
	public List<Usuario> listarUsuarios() throws Exception {
		EntityManager entityManager = em.createEntityManager();
		return entityManager.createQuery("from " + Usuario.class.getName()).getResultList();
	}

	@Override
	public List buscarPorId(Integer id) throws Exception {
		EntityManager entityManager = em.createEntityManager();
		Query query = entityManager.createQuery("from Usuario u where u.id=:id");
		query.setParameter("id", id);
		return query.getResultList();
	}
	@Override
	public void deletarUsuario(Integer id) throws Exception {
		EntityManager entityManager = em.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("delete from Usuario u where u.id=:id").setParameter("id", id);
			  int rowsDeleted = query.executeUpdate();
			  entityManager.getTransaction().commit();
			  entityManager.close();
	}


	@Override
	public void atualizarUsuario(Integer id, Usuario usersAtualizado) throws Exception {
		EntityManager entityManager = em.createEntityManager();
		Usuario user = (Usuario) buscarPorId(id);
		usersAtualizado.setId(user.getId());
		cadastrarUsuario(usersAtualizado);

	}


}
