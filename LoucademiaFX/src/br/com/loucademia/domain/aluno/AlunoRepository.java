package br.com.loucademia.domain.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.loucademia.JDBCMySql;
import br.com.loucademia.domain.acesso.Acesso;

public class AlunoRepository {

    JDBCMySql jdbcConnection = new JDBCMySql();

    public void save(Aluno aluno) throws SQLException {
	Connection conection = jdbcConnection.getConnection();
	String sql = "INSERT INTO Aluno (NOME, SEXO, RG, dataNascimento, SITUACAO,EMAIL,TELEFONE) VALUES (?,?,?,?,?,?,?)";
	// ENDEREÇO
	PreparedStatement pStatement = conection.prepareStatement(sql);
	pStatement.setString(1, aluno.getNome());
	pStatement.setString(2, aluno.getSexo());
	pStatement.setInt(3, aluno.getRg());
	pStatement.setString(4, aluno.getDataNascimento().toString());
	pStatement.setString(5, aluno.getSituacao());
	pStatement.setString(6, aluno.getEmail());
	pStatement.setString(7, aluno.getTelefone());

	pStatement.executeUpdate();
    }

    public void update(Aluno aluno) {
//	em.merge(aluno);
    }

    public Aluno findByMatricula(String matricula) {
//	return em.find(Aluno.class, matricula);

	return null;
    }

    public Aluno findByRG(Integer rg) throws SQLException {
	Aluno result = null;

	Connection conection = jdbcConnection.getConnection();
	String sql = "SELECT nome FROM aluno WHERE rg = ?";
	PreparedStatement pStatement = conection.prepareStatement(sql);
	pStatement.setString(1, rg.toString());
	ResultSet rs = pStatement.executeQuery();
//	result = rs.next();
	conection.close();

	return result;

    }

    public boolean existsByRG(Integer rg) throws SQLException {

	boolean result = false;

	Connection conection = jdbcConnection.getConnection();
	String sql = "SELECT nome FROM aluno WHERE rg = ?";
	PreparedStatement pStatement = conection.prepareStatement(sql);
	pStatement.setString(1, rg.toString());
	ResultSet rs = pStatement.executeQuery();
	result = rs.next();
	conection.close();

	return result;
    }

    public void delete(String matricula) {
	Aluno aluno = findByMatricula(matricula);

	if (aluno != null) {
//	    em.remove(aluno);
	}

    }

    public String getMaxMatriculaAno() {
	return "";
//	em.
//	return em.createQuery("SELECT MAX(a.matricula) FROM Aluno a WHERE a.matricula LIKE :ano", String.class)
//		.setParameter("ano", Year.now() + "%").getSingleResult();
    }

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

    public List<Aluno> listSituacoesAlunos(String situacao) {
//	return em.createQuery("SELECT a FROM Aluno a WHERE a.situacao = :situacao ORDER BY a.nome", Aluno.class)
//		.setParameter("situacao", situacao).getResultList();
	return new ArrayList<>();

    }

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
