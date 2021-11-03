package br.com.loucademia.domain.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco_gen")
    @SequenceGenerator(name = "seq_endereco_gen", sequenceName = "seq_endereco_id")
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "RUA", nullable = false, length = 128)
    private String rua;

    @Column(name = "NUMERO", nullable = true, length = 6)
    private Integer numero;

    @Column(name = "COMPLEMENTO", nullable = true, length = 32)
    private String complemento;

    @Column(name = "CIDADE", nullable = false, length = 64)
    private String cidade;

    @Column(name = "ESTADO", nullable = false) // ESTADO AGORA É UMA ENUM
    private String estado;

    @Column(name = "CEP", nullable = false, length = 8)
    private Integer cep;

    @OneToOne(mappedBy = "endereco")
    private Aluno aluno;

    public String getRua() {
	return rua;
    }

    public void setRua(String rua) {
	this.rua = rua;
    }

    public Integer getNumero() {
	return numero;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	this.cidade = cidade;
    }

    public String getEstado() {
	return estado;
    }

    public void setEstado(String estado) {
	this.estado = estado;
    }

    public Integer getCep() {
	return cep;
    }

    public void setCep(Integer cep) {
	this.cep = cep;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Aluno getAluno() {
	return aluno;
    }

    public void setAluno(Aluno aluno) {
	this.aluno = aluno;
    }

    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Endereco [rua=");
	builder.append(rua);
	builder.append(", numero=");
	builder.append(numero);
	builder.append(", complemento=");
	builder.append(complemento);
	builder.append(", cidade=");
	builder.append(cidade);
	builder.append(", estado=");
	builder.append(estado);
	builder.append(", cep=");
	builder.append(cep);
	builder.append("]");
	return builder.toString();
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
