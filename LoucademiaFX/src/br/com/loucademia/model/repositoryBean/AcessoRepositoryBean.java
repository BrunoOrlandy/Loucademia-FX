package br.com.loucademia.model.repositoryBean;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repository.AcessoRepository;

public class AcessoRepositoryBean implements AcessoRepository {

    private static AcessoRepository repsitory;
    protected EntityManager emf;

    public static AcessoRepository getInstance() {
	if (repsitory == null) {
	    repsitory = new AcessoRepositoryBean();
	}

	return repsitory;
    }

    public AcessoRepositoryBean() {
	emf = getEntityManager();
    }

    private EntityManager getEntityManager() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("loucademia");

	if (emf == null) {
	    emf = factory.createEntityManager();
	}

	return emf;
    }

    @Override
    public Acesso findUltimoAcesso(Aluno aluno) {
	try {
	    return emf.createQuery("SELECT a FROM Acesso a WHERE a.aluno.id = :id ORDER by a.id DESC", Acesso.class)
		    .setParameter("id", aluno.getId()).setMaxResults(1).getSingleResult();

	} catch (NoResultException e) {
	    return null;
	}
    }

    @Override
    public void persist(Acesso ultimoAcesso) throws SQLException {

	try {
	    emf.getTransaction().begin();
	    emf.persist(ultimoAcesso);
	    emf.getTransaction().commit();

	} catch (Exception ex) {
	    ex.printStackTrace();
	    emf.getTransaction().rollback();

	}
    }
}