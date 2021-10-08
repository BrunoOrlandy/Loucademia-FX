package br.com.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable {
	
	// DDD celular
	@Column(name = "CELULAR_DDD", nullable = false, length = 2)
	private Integer dddCelular;
	
	// N�mero celular
	@Column(name = "CELULAR_NUMERO", nullable = false, length = 9)
	private Integer numeroCelular;
	
	// DDD fixo
	@Column(name = "FIXO_DDD", nullable = true, length = 2)
	private Integer dddFixo;
	
	// N�mero fixo
	@Column(name = "FIXO_NUMERO", nullable = true, length = 9)
	private Integer numeroFixo;
	
	// Retorna o ddd do celular
	public Integer getDddCelular() {
		return dddCelular;
	}
	
	// Atribui um ddd ao celular
	public void setDddCelular(Integer dddCelular) {
		this.dddCelular = dddCelular;
	}
	
	// Retorna o n�mero do celular
	public Integer getNumeroCelular() {
		return numeroCelular;
	}
	
	// Atribui um n�mero celular
	public void setNumeroCelular(Integer numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	// Retorna o ddd do fixo
	public Integer getDddFixo() {
		return dddFixo;
	}
	
	// Atribui um ddd ao fixo
	public void setDddFixo(Integer dddFixo) {
		this.dddFixo = dddFixo;
	}
	
	// Retorna o n�mero fixo
	public Integer getNumeroFixo() {
		return numeroFixo;
	}
	
	// Atribui um n�mero fixo
	public void setNumeroFixo(Integer numeroFixo) {
		this.numeroFixo = numeroFixo;
	}	
	
	@Override
	public String toString() {
		return "Telefone [dddCelular=" + dddCelular + ", numeroCelular=" + numeroCelular + ", dddFixo=" + dddFixo
				+ ", numeroFixo=" + numeroFixo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dddCelular == null) ? 0 : dddCelular.hashCode());
		result = prime * result + ((dddFixo == null) ? 0 : dddFixo.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		result = prime * result + ((numeroFixo == null) ? 0 : numeroFixo.hashCode());
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
		Telefone other = (Telefone) obj;
		if (dddCelular == null) {
			if (other.dddCelular != null)
				return false;
		} else if (!dddCelular.equals(other.dddCelular))
			return false;
		if (dddFixo == null) {
			if (other.dddFixo != null)
				return false;
		} else if (!dddFixo.equals(other.dddFixo))
			return false;
		if (numeroCelular == null) {
			if (other.numeroCelular != null)
				return false;
		} else if (!numeroCelular.equals(other.numeroCelular))
			return false;
		if (numeroFixo == null) {
			if (other.numeroFixo != null)
				return false;
		} else if (!numeroFixo.equals(other.numeroFixo))
			return false;
		return true;
	}	
}