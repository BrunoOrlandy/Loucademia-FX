package br.com.loucademia.domain.aluno;

import java.util.List;

import javax.persistence.EntityManager;

public class EstadoRepository {

	private EntityManager em;

	public List<Estado> listEstados() {
		return em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class).getResultList();

//		TypedQuery<Estado> q = em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
//		return q.getResultList();
	}
}
