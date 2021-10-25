package br.com.loucademia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.loucademia.application.util.StringUtils;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

	 public enum Sexo {
		 Masculino, Feminino;
	 }
	 
	 public enum Situacao {
		 Ativo, Inativo, Pendente;
	 }
	 
	// Matrícula do aluno
	@Id
	@Column(name = "ID", nullable = false, length = 8)
	private String matricula;
	
	// Nome do aluno
	@Column(name = "NOME", nullable = false, length = 64)
	private String nome;
	
	// Sexo do aluno
	@Enumerated() // Já faz mapeamento de um 'enum'
	@Column(name = "SEXO", nullable = false)
	private Sexo sexo;
	
	// RG do aluno
	@Column(name = "RG", nullable = false, length = 10)
	private Integer rg;
	
	@Column(name = "NASCIMENTO", nullable = false)
	// Data de nascimento do aluno
	private LocalDate dataNascimento;
	
	@Enumerated
	@Column(name = "SITUACAO", nullable = false)
	// Situação do aluno
	private Situacao situacao;
	
	@Column(name = "EMAIL", nullable = true, length = 64)
	// Email do aluno;
	private String email;
	
	// Endereço do aluno;
	@Embedded // A JPA sabe que o endereço faz parte da entidade 'Aluno' (compartilhando o mesmo ID que o aluno tem)
	private Endereco endereco = new Endereco();
	
	// Telefone do aluno;
	@Embedded // A JPA sabe que o telefone faz parte da entidade 'Aluno' (compartilhando o mesmo ID que o aluno tem)
	private Telefone telefone = new Telefone();	
	
	public void gerarMatricula(String maxMatricula) {

		Year year = Year.now();
		
		if (maxMatricula == null) {
			maxMatricula = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequential = Integer.parseInt(maxMatricula.substring(4));
		sequential++;
		
		this.matricula = year + StringUtils.leftZeroes(sequential, 4);
		
	}
	
	// Retorna a matrícula
	public String getMatricula() {
		return matricula;
	}

	// Recebe uma matrícula
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
	
	// Retorna uma situação
	public Situacao getSituacao() {
		return situacao;
	}

	// Recebe uma situação
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
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
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", sexo=" + sexo + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", situacao=" + situacao + ", email=" + email + ", endereco="
				+ endereco + ", telefone=" + telefone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}	
}	