package br.com.loucademia.domain.aluno;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.loucademia.application.util.StringUtils;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false, length = 8)
    private String matricula;

    @Column(name = "NOME", nullable = false, length = 64)
    private String nome;

    @Column(name = "SEXO", nullable = false)
    private String sexo;

    @Column(name = "RG", nullable = false, length = 10)
    private Integer rg;

    @Column(name = "NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "SITUACAO", nullable = false)
    private String situacao;

    @Column(name = "EMAIL", nullable = true, length = 64)
    private String email;

    @Embedded
    private Endereco endereco = new Endereco();

    @Column(name = "telefone", nullable = true, length = 11)
    private String telefone;

    public void gerarMatricula(String maxMatricula) {

	Year year = Year.now();

	if (maxMatricula == null) {
	    maxMatricula = year + StringUtils.leftZeroes(0, 4);
	}

	int sequential = Integer.parseInt(maxMatricula.substring(4));
	sequential++;

	this.matricula = year + StringUtils.leftZeroes(sequential, 4);

    }

    public String getMatricula() {
	return matricula;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public Integer getRg() {
	return rg;
    }

    public void setRg(Integer rg) {
	this.rg = rg;
    }

    public LocalDate getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
	return sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }

    public String getSituacao() {
	return situacao;
    }

    public void setSituacao(String situacao) {
	this.situacao = situacao;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Endereco getEndereco() {
	return endereco;
    }

    public void setEndereco(Endereco endereco) {
	this.endereco = endereco;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Aluno [matricula=");
	builder.append(matricula);
	builder.append(", nome=");
	builder.append(nome);
	builder.append(", sexo=");
	builder.append(sexo);
	builder.append(", rg=");
	builder.append(rg);
	builder.append(", dataNascimento=");
	builder.append(dataNascimento);
	builder.append(", situacao=");
	builder.append(situacao);
	builder.append(", email=");
	builder.append(email);
	builder.append(", endereco=");
	builder.append(endereco);
	builder.append(", telefone=");
	builder.append(telefone);
	builder.append("]");
	return builder.toString();
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