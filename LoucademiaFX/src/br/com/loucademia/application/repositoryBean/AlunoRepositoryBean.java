package br.com.loucademia.application.repositoryBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public class AlunoRepositoryBean implements AlunoRepository {

    private static AlunoRepository repsitory;
    protected EntityManager emf;

    public static AlunoRepository getInstance() {
		if (repsitory == null) {
		    repsitory = new AlunoRepositoryBean();
		}
	
		return repsitory;
    }

    public AlunoRepositoryBean() {
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
    public void persist(Aluno aluno) throws SQLException {

		try {
		    emf.getTransaction().begin();
		    emf.persist(aluno);
		    emf.getTransaction().commit();
		    emf.close();
		} catch (Exception ex) {
		    ex.printStackTrace();
		    emf.getTransaction().rollback();
		}
    }

    @Override
    public void update(Aluno aluno) {
	emf.merge(aluno);
    }

    @Override
    public Aluno findById(Integer id) {
    	
    	Aluno aluno = new Aluno();
		try {
		    Query q = emf.createQuery("SELECT a FROM Aluno a WHERE a.id = :id");
		    q.setParameter("id", id);
		    List<Aluno> alunoList = q.getResultList();
	
		    if (!alunoList.isEmpty() || alunoList != null) {
			for (Aluno a : alunoList) {
			    aluno = a;
			}
		    }
	
		} catch (NoResultException nre) {
		    return null;
		}
	
		System.out.println("Terminou por aqui");
		return aluno;
    	
    	//return emf.find(Aluno.class, id);
    }

    @Override
    public Aluno findByCPF(String cpf) {

		Aluno aluno = new Aluno();
		try {
		    Query q = emf.createQuery("SELECT a FROM Aluno a WHERE a.cpf = :cpf");
		    q.setParameter("cpf", cpf);
		    List<Aluno> alunoList = q.getResultList();
	
		    if (!alunoList.isEmpty() || alunoList != null) {
			for (Aluno a : alunoList) {
			    aluno = a;
			}
		    }
	
		} catch (NoResultException nre) {
		    return null;
		}
	
		return aluno;
    }

    @Override
    public void remove(Aluno aluno) {
	try {
	    emf.getTransaction().begin();
	    aluno = emf.find(Aluno.class, aluno.getId());
	    emf.remove(aluno);
	    emf.getTransaction().commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	    emf.getTransaction().rollback();
	}
    }

    @Override
    public Aluno getById(Integer id) {
	return emf.find(Aluno.class, id);
    }

    @Override
    public void removeById(Integer id) {
	try {
	    Aluno aluno = getById(id);
	    remove(aluno);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    public List<Aluno> listAlunos(Integer matricula, String nome, Integer cpf, String telefone) {

	StringBuilder jpql = new StringBuilder("SELECT a FROM Aluno a WHERE ");

	if (matricula != null) {
	    jpql.append("a.id = :id OR ");
	}

	if (!StringUtils.isEmpty(nome)) {
	    jpql.append("a.nome LIKE :nome OR ");
	}

	if (cpf != null) {
	    jpql.append("a.cpf = :cpf OR ");
	}

	if (!StringUtils.isEmpty(telefone)) {
	    jpql.append("a.telefone LIKE :telefone");
	}

	// A query vai terminar com '1 = 1'. Forma simples utilizando a tabela verdade
	// sem precisar tirar o AND da String.
	jpql.append("1 = 1");
	TypedQuery<Aluno> q = emf.createQuery(jpql.toString(), Aluno.class);

	if (matricula != null) {
	    q.setParameter("matricula", matricula);
	}

	if (!StringUtils.isEmpty(nome)) {
	    q.setParameter("nome", "%" + nome + "%");
	}

	if (cpf != null) {
	    q.setParameter("cpf", cpf);
	}

	if (telefone != null) {
	    q.setParameter("telefone", telefone);
	}

	return q.getResultList();
//	return new ArrayList<>();
    }

    @Override
    public List<Aluno> listSituacoesAlunos(String situacao) {
//	return em.createQuery("SELECT a FROM Aluno a WHERE a.situacao = :situacao ORDER BY a.nome", Aluno.class)
//		.setParameter("situacao", situacao).getResultList();
	return new ArrayList<>();

    }

    @Override
    public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
		StringBuilder jpql = new StringBuilder("SELECT a FROM Acesso a WHERE ");
	
		if (!StringUtils.isEmpty(matricula)) {
		    jpql.append("a.aluno.matricula = :matricula AND ");
		}
	
		if (dataInicial != null) {
		    jpql.append("a.entrada >= :entradaInicio AND ");
		}
	
		if (dataFinal != null) {
		    jpql.append("a.saida <= :saidaFim AND ");
		}
	
		jpql.append("1 = 1 ORDER BY a.entrada");
	
		TypedQuery<Acesso> q = emf.createQuery(jpql.toString(), Acesso.class);
	
		if (!StringUtils.isEmpty(matricula)) {
		    q.setParameter("matricula", matricula);
		}
	
		if (dataInicial != null) {
		    LocalDateTime ldt = LocalDateTime.of(dataInicial, LocalTime.of(0, 0, 0));
		    q.setParameter("entradaInicio", ldt);
		}
	
		if (dataFinal != null) {
		    LocalDateTime ldt = LocalDateTime.of(dataFinal, LocalTime.of(23, 59, 59));
		    q.setParameter("saidaFim", ldt);
		}
	
		return q.getResultList();
	//return new ArrayList<>();

    }

    @Override
    public List<Aluno> listAlunos(Aluno aluno) {

		StringBuilder jpql = new StringBuilder("SELECT a FROM Aluno a WHERE 1 = 1 ");
	
		if (aluno.getId() != null) {
		    jpql.append("AND a.id = :id ");
		}
	
		if (!StringUtils.isEmpty(aluno.getNome())) {
		    jpql.append("AND UPPER(a.nome) LIKE :nome ");
		}
	
		if (aluno.getCpf() != null) {
		    jpql.append("AND  a.cpf = :cpf ");
		}
	
		if (aluno.getTelefone() != null) {
		    jpql.append(" AND a.telefone LIKE :telefone ");
		}
	
		Query q = emf.createQuery(jpql.toString());
	
		if (aluno.getId() != null) {
		    q.setParameter("id", aluno.getId());
		}
	
		if (!StringUtils.isEmpty(aluno.getNome())) {
		    q.setParameter("nome", "%" + aluno.getNome().toUpperCase() + "%");
		}
	
		if (aluno.getCpf() != null) {
		    q.setParameter("cpf", aluno.getCpf());
		}
	
		if (aluno.getTelefone() != null) {
		    q.setParameter("telefone", "%" + aluno.getTelefone() + "%");
		}
	
		return q.getResultList();
    }
}
