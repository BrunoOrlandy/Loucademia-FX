package br.com.loucademia.interfaces.aluno.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Aluno;

@Named // Faz com que o Bean participe dentro do CDI (api que faz parte do Java EE que gerencia o ciclo de vida de objetos)
@RequestScoped // Siginifica que esse objeto vai viver só durante o processo de requisição
public class AlunoBean implements Serializable {

	@EJB
	private AlunoService alunoService;
	
	@Inject
	private FacesContext facesContext;
	
	private Aluno aluno = new Aluno();
	
	private String matricula;
	
	private String titulo = "Novo aluno";
	
	public void carregar() {		
		if (!StringUtils.isEmpty(matricula)) {
			aluno = alunoService.findByMatricula(matricula);
			titulo = "Alterar aluno";
		}
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public String gravar() {
		
		Aluno other;
		other = alunoService.findByRG(aluno.getRg());
		
		if (aluno.getRg().equals(other.getRg())) {
			facesContext.addMessage(null, new FacesMessage("Já existe aluno com o RG informado!"));
			return null;
		}
		
		alunoService.createOrUpdate(aluno);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso!"));
		return null;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTitulo() {
		return titulo;
	}
}
