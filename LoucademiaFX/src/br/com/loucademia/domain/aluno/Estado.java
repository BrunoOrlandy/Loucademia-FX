package br.com.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADO")
public class Estado implements Serializable {
	
	
	@Id
	@Column(name = "SIGLA", nullable = false, length = 2)
	private String sigla;
	
	@Column(name = "NOME", nullable = false, length = 30)
	private String nome;
	
	// Retorna a sigla do estado
	public String getSigla() {
		return sigla;
	}
	
	// Atribui uma sigla ao estado
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
	}
	
	// Retorna o nome do estado
	public String getNome() {
		return nome;
	}
	
	// Atribui um nome ao estado
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Estado [sigla=" + sigla + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		
		return true;
	}	
}
