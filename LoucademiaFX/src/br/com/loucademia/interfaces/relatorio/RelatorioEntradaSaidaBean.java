package br.com.loucademia.interfaces.relatorio;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;

public class RelatorioEntradaSaidaBean {

	private AlunoService alunoService;

	private String matricula;
	private LocalDate dataInicial;
	private LocalDate dataFinal;

	private List<Acesso> acessos;

	public void carregarAluno() {
		if (!StringUtils.isEmpty(matricula)) {
			gerarRelatorio();
		}
	}

	public String gerarRelatorio() {
		try {
			acessos = alunoService.listAcessosAlunos(matricula, dataInicial, dataFinal);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public List<Acesso> getAcessos() {
		return acessos;
	}

}
