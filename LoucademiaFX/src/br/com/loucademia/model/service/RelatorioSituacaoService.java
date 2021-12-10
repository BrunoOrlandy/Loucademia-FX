package br.com.loucademia.model.service;

import java.util.List;

import br.com.loucademia.model.model.Aluno;

public interface RelatorioSituacaoService {
    public List<Aluno> gerarRelatorio(Integer id, String situacao);

    public List<Aluno> listaAlunosById(Integer id);
}
