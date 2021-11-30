package br.com.loucademia.application.repositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.com.loucademia.application.repository.AcessoRepository;
import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

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
					.setParameter("id", aluno.getId())
					.setMaxResults(1)
					.getSingleResult();
		    
		} catch (NoResultException e) {
		    return null;
		}
		
    }

    @Override
    public void store(Acesso acesso) {
    	emf.persist(acesso);
    }
}
