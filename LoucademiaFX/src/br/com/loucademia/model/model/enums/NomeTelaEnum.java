package br.com.loucademia.model.model.enums;

public enum NomeTelaEnum {

	LOGIN("LOGIN", "login"), 
	MENU("MENU", "menu"), 
	NOVO_ALUNO("NOVO_ALUNO", "novo_aluno"), 
	PESQUISAR_ALUNO("PESQUISAR_ALUNO", "pesquisar_aluno"), 
	CONTROLE_ACESSO("CONTROLE_ACESSO", "controle_acesso"),
	RELATORIO_ENTRADA_SAIDA("RELATORIO_ENTRADA_SAIDA", "relatorio_entrada_saida"),
	RELATORIO_SITUACAO("RELATORIO_SITUACAO", "relatorio_situacao");

	private String id;
	private String nome;

	private NomeTelaEnum(String id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}