package br.com.loucademia.domain.aluno;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;

@Stateless
public class EstadoRepository {
	
	// Porta de entrada pra JPA
	// Cabe ao CDI atribuir valor para esse atributo
	@PersistenceContext
	private EntityManager em;
	
	public List<Estado> listEstados() {	
		return em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class).getResultList();		
		
//		TypedQuery<Estado> q = em.createQuery("SELECT e FROM Estado e ORDER BY e.nome", Estado.class);
//		return q.getResultList();
	}
}
