package br.com.loucademia.application.repositoryBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.loucademia.application.repository.AlunoRepository;
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
    public Aluno findById(String id) {
	return emf.find(Aluno.class, Integer.valueOf(id));
    }

    @Override
    public Aluno findByCPF(Integer cpf) throws SQLException {

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
    public Aluno getById(String id) {
	return emf.find(Aluno.class, id);
    }

    @Override
    public void removeById(String id) {
	try {
	    Aluno aluno = getById(id);
	    remove(aluno);
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone) {

//	StringBuilder jpql = new StringBuilder("SELECT a FROM Aluno a WHERE ");
//
//	if (!StringUtils.isEmpty(matricula)) {
//	    jpql.append("a.matricula = :matricula AND ");
//	}
//
//	if (!StringUtils.isEmpty(nome)) {
//	    jpql.append("a.nome LIKE :nome AND ");
//	}
//
//	if (rg != null) {
//	    jpql.append("a.rg = :rg AND ");
//	}
//
//	if (telefone != null) {
//	    jpql.append("(a.telefone.numeroCelular LIKE :celular OR a.telefone.numeroFixo LIKE :fixo) AND ");
//	}
//
//	// A query vai terminar com '1 = 1'. Forma simples utilizando a tabela verdade
//	// sem precisar tirar o AND da String.
//	jpql.append("1 = 1");
//	TypedQuery<Aluno> q = em.createQuery(jpql.toString(), Aluno.class);
//
//	if (!StringUtils.isEmpty(matricula)) {
//	    q.setParameter("matricula", matricula);
//	}
//
//	if (!StringUtils.isEmpty(nome)) {
//	    q.setParameter("nome", "%" + nome + "%");
//	}
//
//	if (rg != null) {
//	    q.setParameter("rg", rg);
//	}
//
//	if (telefone != null) {
//	    q.setParameter("celular", telefone);
//	    q.setParameter("fixo", telefone);
//	}
//
//	return q.getResultList();
	return new ArrayList<>();
    }

    @Override
    public List<Aluno> listSituacoesAlunos(String situacao) {
//	return em.createQuery("SELECT a FROM Aluno a WHERE a.situacao = :situacao ORDER BY a.nome", Aluno.class)
//		.setParameter("situacao", situacao).getResultList();
	return new ArrayList<>();

    }

    @Override
    public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
//	StringBuilder jpql = new StringBuilder("SELECT a FROM Acesso a WHERE ");
//
//	if (!StringUtils.isEmpty(matricula)) {
//	    jpql.append("a.aluno.matricula = :matricula AND ");
//	}
//
//	if (dataInicial != null) {
//	    jpql.append("a.entrada >= :entradaInicio AND ");
//	}
//
//	if (dataFinal != null) {
//	    jpql.append("a.saida <= :saidaFim AND ");
//	}
//
//	jpql.append("1 = 1 ORDER BY a.entrada");
//
//	TypedQuery<Acesso> q = em.createQuery(jpql.toString(), Acesso.class);
//
//	if (!StringUtils.isEmpty(matricula)) {
//	    q.setParameter("matricula", matricula);
//	}
//
//	if (dataInicial != null) {
//	    LocalDateTime ldt = LocalDateTime.of(dataInicial, LocalTime.of(0, 0, 0));
//	    q.setParameter("entradaInicio", ldt);
//	}
//
//	if (dataFinal != null) {
//	    LocalDateTime ldt = LocalDateTime.of(dataFinal, LocalTime.of(23, 59, 59));
//	    q.setParameter("saidaFim", ldt);
//	}
//
//	return q.getResultList();
	return new ArrayList<>();

    }
}
