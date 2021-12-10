package br.com.loucademia.model.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import br.com.loucademia.model.model.valueObject.AlunoEstadoVo;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    public Aluno() {
	endereco = new Endereco();
    }

    @Id
    @GenericGenerator(name = "aluno_gen", strategy = "increment")
    @GeneratedValue(generator = "aluno_gen")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "NOME", nullable = false, length = 64)
    private String nome;

    @Column(name = "SEXO", nullable = true)
    private String sexo;

    @Column(name = "CPF", nullable = false, length = 10)
    private String cpf;

    @Column(name = "NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "SITUACAO", nullable = true)
    private String situacao;

    @Column(name = "EMAIL", nullable = true, length = 64)
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")//referencedColumnName = "id"
    private Endereco endereco;

    @Column(name = "telefone", nullable = true, length = 11)
    private String telefone;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
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
	builder.append("Aluno [id=");
	builder.append(id);
	builder.append(", nome=");
	builder.append(nome);
	builder.append(", sexo=");
	builder.append(sexo);
	builder.append(", cpf=");
	builder.append(cpf);
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
	result = prime * result + ((id == null) ? 0 : id.hashCode());
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
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public Aluno converterVoParaAluno(AlunoEstadoVo vo) {

	Aluno aluno = new Aluno();

	aluno.setNome(vo.getNome());
	aluno.setSexo(vo.getSexo());
	aluno.setCpf(vo.getCpf());
	aluno.setDataNascimento(LocalDate.parse(vo.getDataNascimento()));
	aluno.setSituacao(vo.getSituacao());
	aluno.setEmail(vo.getEmail());
	aluno.getEndereco().setCep(vo.getCep());
	aluno.getEndereco().setCidade(vo.getCidade());
	aluno.getEndereco().setComplemento(vo.getComplemento());
	aluno.getEndereco().setEstado(vo.getEstado());
	aluno.getEndereco().setNumero(vo.getNumero());
	aluno.getEndereco().setRua(vo.getRua());

	return aluno;
    }

}