package br.aplication.domain;


public class Aluno extends Pessoa {

	private SituacaoEnum situacao;
	
	public SituacaoEnum getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoEnum situacao) {
		this.situacao = situacao;
	}
}
