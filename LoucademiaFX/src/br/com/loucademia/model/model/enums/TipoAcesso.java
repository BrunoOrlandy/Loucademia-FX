package br.com.loucademia.model.model.enums;

public enum TipoAcesso {
    ENTRADA("E", "Entrada"), SAIDA("S", "Saída");

    private String id;
    private String nome;

    private TipoAcesso(String id, String nome) {
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
