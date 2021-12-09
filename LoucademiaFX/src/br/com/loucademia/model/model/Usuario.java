package br.com.loucademia.model.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "usuario")
@Table(name = "usuario")
public class Usuario implements Serializable {
//insert into usuario values(nextval('seq_usuario_id')  ,'a','administrador','a');
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuario_gen")
    @SequenceGenerator(name = "seq_usuario_gen", sequenceName = "seq_usuario_id")
    @Column(name = "id_usuario", nullable = false)
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "login", nullable = false)
    private String login;

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	this.nome = nome;
    }

    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

}
