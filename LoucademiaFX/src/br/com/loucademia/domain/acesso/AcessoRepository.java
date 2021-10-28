package br.com.loucademia.domain.acesso;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.loucademia.domain.aluno.Aluno;

public class AcessoRepository {

	private EntityManager em;

	public Acesso findUltimoAcesso(Aluno aluno) {
		try {
			return em
					.createQuery("SELECT a FROM Acesso a WHERE a.aluno.matricula = :matricula ORDER by a.id DESC",
							Acesso.class)
					.setParameter("matricula", aluno.getMatricula()).setMaxResults(1).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public void store(Acesso acesso) {
		em.persist(acesso);
	}
}
