package br.com.loucademia.model.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;

public interface AlunoRepository {

    void persist(Aluno aluno) throws SQLException;

    Aluno findById(Integer id);

    Aluno findByCPF(String cpf);

    public Aluno findByCPFandId(Integer id, String cpf);

    void remove(Aluno aluno);

    Aluno getById(Integer id);

    void removeById(Integer id);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer cpf, String telefone);

    List<Aluno> listAlunos(Aluno aluno);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(Integer id, LocalDate dataInicial, LocalDate dataFinal);

    void update(Aluno aluno);
}