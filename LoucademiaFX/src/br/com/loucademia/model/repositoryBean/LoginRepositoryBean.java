package br.com.loucademia.model.repositoryBean;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.loucademia.model.model.Usuario;
import br.com.loucademia.model.repository.LoginRepository;
import br.com.loucademia.model.util.EntityManagerUtil;

public class LoginRepositoryBean implements LoginRepository {

    private EntityManagerUtil entityManager = new EntityManagerUtil();

    @Override
    public boolean existeUsuario(String login, String senha) throws SQLException {

	EntityManager emf = entityManager.getEntityManager();

	Query q = emf.createQuery("SELECT u.login FROM usuario u WHERE u.login = :login AND u.senha = :senha");
	q.setParameter("login", login);
	q.setParameter("senha", senha);

	return q.getResultList().isEmpty();

    }

    @Override
    public List<Usuario> findUsuario(String login, String senha) throws SQLException {

	EntityManager emf = entityManager.getEntityManager();

	Query q = emf.createQuery("SELECT u FROM usuario u WHERE u.login = :login AND u.senha = :senha");
	q.setParameter("login", login);
	q.setParameter("senha", senha);

	return q.getResultList();
    }

}
