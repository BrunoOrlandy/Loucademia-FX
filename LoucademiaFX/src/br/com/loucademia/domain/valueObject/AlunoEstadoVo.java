package br.com.loucademia.domain.valueObject;

public class AlunoEstadoVo {
    private Integer id;
    private String nome;
    private String telefone;

    private String sexo;
    private String cpf;
    private String situacao;
    private String email;
    private String dataNascimento;
    private String rua;
    private String complemento;
    private String cidade;
    private String estado;
    private Integer cep;
    private Integer numero;

    public AlunoEstadoVo() {
	super();
    }

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

    public String getSexo() {
	return sexo;
    }

    public void setSexo(String sexo) {
	this.sexo = sexo;
    }

    public String getTelefone() {
	return telefone;
    }

    public void setTelefone(String telefone) {
	this.telefone = telefone;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	this.cpf = cpf;
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

    public String getDataNascimento() {
	return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
	this.dataNascimento = dataNascimento;
    }

    public String getRua() {
	return rua;
    }

    public void setRua(String rua) {
	this.rua = rua;
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

    public Integer getNumero() {
	return numero;
    }

    public void setNumero(Integer numero) {
	this.numero = numero;
    }

}
