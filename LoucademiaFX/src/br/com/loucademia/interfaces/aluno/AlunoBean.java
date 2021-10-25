package br.com.loucademia.interfaces.aluno;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.domain.aluno.Aluno;

public class AlunoBean {
	
	private AlunoService alunoService;
	
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
		
		System.out.println("Registro Salvo");
		
		Aluno other;
		other = alunoService.findByRG(aluno.getRg());
		
		if (aluno.getRg().equals(other.getRg())) {			
			System.out.println("Já existe aluno com o RG informado!");
			return null;
		}
		
		alunoService.createOrUpdate(aluno);
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
