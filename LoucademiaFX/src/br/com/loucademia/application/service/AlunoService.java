package br.com.loucademia.application.service;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface AlunoService {

    String validarAlunoESalvar(Aluno aluno);

    Aluno buscarAlunoById(Integer id);

    void createOrUpdate(Aluno aluno);

    void deleteById(Integer id);

    void deletarAluno(Aluno aluno);

    Aluno findByCPF(String cpf);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer rg, String telefone);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(Integer id, LocalDate dataInicial, LocalDate dataFinal);

    String gravar(Aluno aluno);

}