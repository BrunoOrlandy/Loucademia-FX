package br.aplication.domain;

import java.util.Arrays;
import java.util.List;

public enum SexoEnum {

	MASCULINO("M", "Masculino"), FEMININO("F", "Feminino");

	private String id;
	private String descricao;

	private SexoEnum(String id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public static List<SexoEnum> getListaSexoEnum() {
		return Arrays.asList(SexoEnum.values());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
