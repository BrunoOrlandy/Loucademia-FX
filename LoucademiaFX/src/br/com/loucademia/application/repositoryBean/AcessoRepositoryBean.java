package br.com.loucademia.application.repositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.loucademia.application.repository.AcessoRepository;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public class AcessoRepositoryBean implements AcessoRepository {

    private EntityManager em;

    @Override
    public Acesso findUltimoAcesso(Aluno aluno) {
	try {
	    return em.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER by a.id DESC",
		    Acesso.class).setParameter("id", aluno.getId()).setMaxResults(1).getSingleResult();
	} catch (NoResultException e) {
	    return null;
	}
    }

    @Override
    public void store(Acesso acesso) {
	em.persist(acesso);
    }
}
