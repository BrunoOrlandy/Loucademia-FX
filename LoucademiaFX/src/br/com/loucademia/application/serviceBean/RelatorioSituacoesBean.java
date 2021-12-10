package br.com.loucademia.application.serviceBean;

import java.io.Serializable;
import java.util.List;

import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.domain.aluno.Aluno;

public class RelatorioSituacoesBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AlunoServiceBean alunoServiceBean;
    private AlunoRepositoryBean alunoRepositoryBean = new AlunoRepositoryBean();

    private String situacao;


	private List<Aluno> alunos;

    public void check() {
		String clear = "";
	
		if (clear != null && Boolean.valueOf(clear)) {
		    situacao = null;
		    alunos = null;
		}
    }

    public List<Aluno> gerarRelatorio(Integer id, String situacao) {    	
		alunos = alunoRepositoryBean.listSituacoesAlunos(id, situacao);
		return alunos;
    }

    public List<Aluno> getAlunos() {
    	return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
    	this.alunos = alunos;
    }
    
    public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
	public List<Aluno> listaAlunosById(Integer id) {
		
		return alunoRepositoryBean.listaAlunosById(id);
	}
	

}
