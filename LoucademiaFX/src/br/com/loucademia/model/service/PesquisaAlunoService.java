package br.com.loucademia.model.service;

import java.util.List;

import br.com.loucademia.model.model.Aluno;

public interface PesquisaAlunoService {

    public String pesquisar(Integer matricula, String nome, Integer rg, String telefone);

    public String excluir(Integer id);
    
    public List<Aluno> buscarAluno(Aluno alunoPesquisa);
}