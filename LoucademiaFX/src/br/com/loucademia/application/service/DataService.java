package br.com.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
// EJB = Componente de negócio que executa a lógica de negócio, muito utilizado para banco de dados
// Pode-se utilizar CDI para injetar dependências no EJB
import javax.ejb.Stateless;

import br.com.loucademia.domain.aluno.Aluno.Sexo;
import br.com.loucademia.domain.aluno.Aluno.Situacao;
import br.com.loucademia.domain.aluno.Estado;
import br.com.loucademia.domain.aluno.EstadoRepository;

// EJB do tipo "Stateçess' não mantém estado
// Cada método chamado tem que ter seu processo finalizado dentro dele mesmo
// Não pode utilizar atributos gerenciáveis por se tratar de um processo escalável, evitando inclusive valores inconsistentes
@Stateless 
public class DataService {

	@EJB
	private EstadoRepository estadoRepository;
	
	public List<Estado> listEstados() {
		return estadoRepository.listEstados();
	}
	
	public Sexo[] getSexos() {
		return Sexo.values();
	}
	
	public Situacao[] getSituacoes() {
		return Situacao.values();
	}
}
