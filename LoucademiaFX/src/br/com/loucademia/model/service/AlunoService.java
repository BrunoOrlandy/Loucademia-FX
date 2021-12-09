package br.com.loucademia.model.service;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;

public interface AlunoService {

    String validarAlunoESalvar(Aluno aluno);

    boolean isCPFjaInformado(Aluno aluno);

    Aluno buscarAlunoById(Integer id);

    void deleteById(Integer id);

    void deletarAluno(Aluno aluno);

    Aluno findByCPF(String cpf);

    List<Aluno> listAlunos(Integer matricula, String nome, Integer rg, String telefone);

    List<Aluno> listSituacoesAlunos(String situacao);

    List<Acesso> listAcessosAlunos(Integer id, LocalDate dataInicial, LocalDate dataFinal);

    String gravar(Aluno aluno);

}