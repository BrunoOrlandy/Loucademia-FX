
public class Endereco {
	
	// Nome para a rua
	private String rua;
	
	// N�mero da resid�ncia
	private Integer numero;
	
	// Complemento de localiza��o
	private String complemento;
	
	// Nome da cidade
	private String cidade;
	
	// Instancia um objeto do tipo 'Estado'
	private Estado estado = new Estado();
	
	// CEP
	private Integer cep;
	
	// Retorna o nome da rua
	public String getRua() {
		return rua;
	}
	
	// Atribui o nome da rua
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	// Retorna o n�mero da resid�ncia
	public Integer getNumero() {
		return numero;
	}
	
	// Atribui um n�mero � resid�ncia
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	// Retorna o complemento
	public String getComplemento() {
		return complemento;
	}

	// Atribui um complemento
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	// Retorna o nome da cidade
	public String getCidade() {
		return cidade;
	}
	
	// Atribui um nome � cidade
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	// Retorna o estado
	public Estado getEstado() {
		return estado;
	}

	// Atribui um estado
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	// Retorna o cep
	public Integer getCep() {
		return cep;
	}

	// Atribui um cep
	public void setCep(Integer cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}	
}
