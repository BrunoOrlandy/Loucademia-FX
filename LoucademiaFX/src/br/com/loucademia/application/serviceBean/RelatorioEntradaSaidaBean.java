package br.com.loucademia.application.serviceBean;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.aluno.Acesso;

public class RelatorioEntradaSaidaBean {

    private AlunoService alunoService;

    private Integer id;
    private LocalDate dataInicial;
    private LocalDate dataFinal;

    private List<Acesso> acessos;

    public void carregarAluno() {
	if (id != null) {
	    gerarRelatorio();
	}
    }

    public String gerarRelatorio() {
	try {
	    acessos = alunoService.listAcessosAlunos(id, dataInicial, dataFinal);
	} catch (ValidationException e) {
	    e.printStackTrace();
	}
	return null;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
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
