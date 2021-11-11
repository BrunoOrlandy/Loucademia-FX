package br.com.loucademia.application.service;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface AlunoService {

    String validarAlunoESalvar(Aluno aluno);

    Aluno buscarAlunoById(String id);

    void createOrUpdate(Aluno aluno);

    void delete(String matricula);

    Aluno findByMatricula(String matricula);

    Aluno findByRG(Integer rg);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer rg, String telefone);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal);

    String gravar(Aluno aluno);

}