package br.com.loucademia.application.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.AlunoRepository;
import br.com.loucademia.domain.aluno.Aluno.Situacao;

//EJB do tipo "Stateçess' não mantém estado
//Cada método chamado tem que ter seu processo finalizado dentro dele mesmo
//Não pode utilizar atributos gerenciáveis por se tratar de um processo escalável, evitando inclusive valores inconsistentes
@Stateless
public class AlunoService {

	@EJB
	private AlunoRepository alunoRepository;
	
	
	public void createOrUpdate(Aluno aluno) {
		
		if (StringUtils.isEmpty(aluno.getMatricula())) {
			create(aluno);
		} else {
			update(aluno);
		}
	}
	
	private void create(Aluno aluno) {
		
		Validation.assertionNotEmpty(aluno);
		
		String maxMatricula = alunoRepository.getMaxMatriculaAno();		
		aluno.gerarMatricula(maxMatricula);				
		alunoRepository.store(aluno);
	}
	
	public void delete(String matricula) {
		alunoRepository.delete(matricula);
	}
	
	private void update(Aluno aluno) {
		
		Validation.assertionNotEmpty(aluno);
		Validation.assertionNotEmpty(aluno.getMatricula());		
		alunoRepository.update(aluno);
	}
	
	public Aluno findByMatricula(String matricula) {
		return alunoRepository.findByMatricula(matricula);
	}
	
	public Aluno findByRG(Integer rg) {
		
		return alunoRepository.findByRG(rg);
	}
	
	public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone) {
		
		if (StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome) && rg == null && telefone == null) {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido");
		}
		
		return alunoRepository.listAlunos(matricula, nome, rg, telefone);
	}
	
	public List<Aluno> listSituacoesAlunos(Situacao situacao) {
		Validation.assertionNotEmpty(situacao);
		return alunoRepository.listSituacoesAlunos(situacao);
	}
	
	public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
		if (StringUtils.isEmpty(matricula) && dataInicial == null && dataFinal == null) {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido");
		}
		
		return alunoRepository.listAcessosAlunos(matricula, dataInicial, dataFinal);
	}
}
