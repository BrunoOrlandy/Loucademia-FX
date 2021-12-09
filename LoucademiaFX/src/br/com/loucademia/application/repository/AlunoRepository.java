package br.com.loucademia.application.repository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface AlunoRepository {

    void persist(Aluno aluno) throws SQLException;

    void update(Aluno aluno);

    Aluno findById(Integer id);

    Aluno findByCPF(String cpf);

    void remove(Aluno aluno);

    Aluno getById(Integer id);

    void removeById(Integer id);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer cpf, String telefone);

    List<Aluno> listAlunos(Aluno aluno);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(Integer id, LocalDate dataInicial, LocalDate dataFinal);
    
    public Aluno findByCPFandId(Integer id, String cpf);

}