package br.com.loucademia.domain.aluno;

public enum SituacaoEnum {

    ATIVO("A", "Ativo"), INATIVO("I", "Inativo"), PENDENTE("P", "Pendente");

    private String id;
    private String nome;

    private SituacaoEnum(String id, String nome) {
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
