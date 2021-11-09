package br.com.loucademia.application.repositoryBean;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.loucademia.application.repository.EstadoRepository;
import br.com.loucademia.domain.aluno.Estado;

public class EstadoRepositoryBean implements EstadoRepository {

	private EntityManager em;

	@Override
	public List<Estado> listEstados() {
		return em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class).getResultList();

//		TypedQuery<Estado> q = em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
//		return q.getResultList();
	}
}
