package br.com.loucademia.application.serviceBean;

import java.io.Serializable;
import java.util.List;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.domain.aluno.Aluno;

public class RelatorioSituacoesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AlunoService alunoService;

    private String situacao;

    private List<Aluno> alunos;

    public void check() {
	String clear = "";

	if (clear != null && Boolean.valueOf(clear)) {
	    situacao = null;
	    alunos = null;
	}
    }

    public String gerarRelatorio() {
	alunos = alunoService.listSituacoesAlunos(situacao);
	return null;
    }

    public List<Aluno> getAlunos() {
	return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
	this.alunos = alunos;
    }

}
