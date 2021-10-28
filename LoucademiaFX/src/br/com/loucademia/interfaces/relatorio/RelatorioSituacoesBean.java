package br.com.loucademia.interfaces.relatorio;

import java.io.Serializable;
import java.util.List;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

public class RelatorioSituacoesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private AlunoService alunoService;

	private Situacao situacao;

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

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}
