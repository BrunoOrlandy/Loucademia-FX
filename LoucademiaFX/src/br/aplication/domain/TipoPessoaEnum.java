package br.aplication.domain;

import java.util.Arrays;
import java.util.List;

public enum TipoPessoaEnum {

	ALUNO("A", "Aluno"), INSTRUTOR("I", "Instrutor"), RECEPCIONISTA("R", "Recepcionista");

	private String id;
	private String name;

	private TipoPessoaEnum(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static List<TipoPessoaEnum> getListaTipoPessoaEnum() {
		return Arrays.asList(TipoPessoaEnum.values());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
