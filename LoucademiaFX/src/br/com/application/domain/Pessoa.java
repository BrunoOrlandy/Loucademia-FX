import java.time.LocalDate;
import java.time.Year;

public class Pessoa {
			
	private String codigo;
	private String nome;
	private Sexo sexo;
	private Integer rg;
	private LocalDate dataNascimento ;
	private String email;
	
	private Endereco endereco = new Endereco();	
	private Telefone telefone = new Telefone();	
	
	private TipoDePessoa pessoa;

	// Retorna um código
	public String getCodigo() {
		return codigo;
	}

	// Recebe um código
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	// Retorna o nome
	public String getNome() {
		return nome;
	}

	// Recebe um nome
	public void setNome(String nome) {
		this.nome = nome;
	}

	// Retorna o sexo
	public Sexo getSexo() {
		return sexo;
	}

	// Recebe um sexo
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	// Retorna o rg
	public Integer getRg() {
		return rg;
	}

	// Recebe um rg
	public void setRg(Integer rg) {
		this.rg = rg;
	}

	// Retorna a data de nascimento
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	// Recebe uma data de nascimento
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	

	// Retorna o email
	public String getEmail() {
		return email;
	}

	// Recebe um email
	public void setEmail(String email) {
		this.email = email;
	}

	// Retorna o endereço
	public Endereco getEndereco() {
		return endereco;
	}

	// Recebe um endereço
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	// Retorna o telefone
	public Telefone getTelefone() {
		return telefone;
	}

	// Recebe um telefone
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Aluno [codigo=" + codigo + ", nome=" + nome + ", sexo=" + sexo + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", email=" + email + ", endereco="
				+ endereco + ", telefone=" + telefone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}	
}
