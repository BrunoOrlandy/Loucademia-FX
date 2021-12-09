package br.com.loucademia.model.serviceBean;

import java.io.Serializable;
import java.util.List;

import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.service.AlunoService;

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
