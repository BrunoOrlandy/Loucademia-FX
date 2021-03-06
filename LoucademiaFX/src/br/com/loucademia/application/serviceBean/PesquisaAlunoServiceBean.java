package br.com.loucademia.application.serviceBean;

import java.util.List;
import java.util.Map;

import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.service.PesquisaAlunoService;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.aluno.Aluno;

public class PesquisaAlunoServiceBean implements PesquisaAlunoService {

    private AlunoRepository alunoRepository;

    private Map<String, String> requestParamsMap;

    private String matricula;
    private String nome;
    private Integer rg;
    private Integer telefone;

    private List<Aluno> alunos;

    public void check() {
	String clear = requestParamsMap.get("clear");

	if (clear != null && Boolean.valueOf(clear)) {
	    matricula = null;
	    nome = null;
	    rg = null;
	    telefone = null;
	    alunos = null;
	}
    }

    public String pesquisar() {

	try {
	    alunos = alunoRepository.listAlunos(matricula, nome, rg, telefone);
	} catch (ValidationException e) {
	    return null;
	}

	return null;
    }

    public String excluir(String matricula) {

	alunoRepository.removeById(matricula);
	return pesquisar();
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

    public Integer getTelefone() {
	return telefone;
    }

    public void setTelefone(Integer telefone) {
	this.telefone = telefone;
    }

    public List<Aluno> getAlunos() {
	return alunos;
    }

    public List<Aluno> buscarAluno(Aluno alunoPesquisa) {
	   return alunoRepository.listAlunos(matricula, nome, rg, telefone);
	    
	}
}
