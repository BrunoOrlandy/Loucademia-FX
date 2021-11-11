package br.com.loucademia.application.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface AlunoRepository {

    void persist(Aluno aluno) throws SQLException;

    void update(Aluno aluno);

    Aluno findById(String id);

    Aluno findByCPF(Integer cpf) throws SQLException;

    void remove(Aluno aluno);

    Aluno getById(String id);

    void removeById(String id);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer cpf, String telefone);

    List<Aluno> listAlunos(Aluno aluno);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal);

}