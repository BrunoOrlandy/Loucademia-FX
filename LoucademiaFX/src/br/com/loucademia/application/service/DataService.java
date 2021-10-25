package br.com.loucademia.application.service;

import java.util.List;

import javax.ejb.EJB;
// EJB = Componente de neg�cio que executa a l�gica de neg�cio, muito utilizado para banco de dados
// Pode-se utilizar CDI para injetar depend�ncias no EJB
import javax.ejb.Stateless;

import br.com.loucademia.domain.aluno.Aluno.Sexo;
import br.com.loucademia.domain.aluno.Aluno.Situacao;
import br.com.loucademia.domain.aluno.Estado;
import br.com.loucademia.domain.aluno.EstadoRepository;

// EJB do tipo "State�ess' n�o mant�m estado
// Cada m�todo chamado tem que ter seu processo finalizado dentro dele mesmo
// N�o pode utilizar atributos gerenci�veis por se tratar de um processo escal�vel, evitando inclusive valores inconsistentes
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
