package br.com.loucademia.domain.aluno;

public enum SexoEnum {
    MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");

    private String id;
    private String nome;

    private SexoEnum(String id, String name) {
	this.id = id;
	this.nome = name;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return nome;
    }

    public void setName(String name) {
	this.nome = name;
    }

}
