package br.com.loucademia.application.service;

import java.sql.SQLException;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;
import br.com.loucademia.domain.acesso.AcessoRepository;
import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.AlunoRepository;

public class AcessoService {

    private AcessoRepository acessoRepository;

    private AlunoRepository alunoRepository;

    public TipoAcesso registrarAcesso(String matricula, Integer rg) throws SQLException {

	if (StringUtils.isEmpty(matricula) && rg == null) {
	    throw new ValidationException("� preciso fornecer a matr�cula ou o RG do aluno");
	}

	Aluno aluno;
	if (StringUtils.isEmpty(matricula)) {
	    aluno = alunoRepository.findByRG(rg);
	} else {
	    aluno = alunoRepository.findByMatricula(matricula);
	}

	if (aluno == null) {
	    throw new ValidationException("O aluno n�o foi encontrado");
	}

	Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
	TipoAcesso tipoAcesso;

	if (ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPrenchidas()) {
	    ultimoAcesso = new Acesso();
	    ultimoAcesso.setAluno(aluno);
	    tipoAcesso = ultimoAcesso.registrarAcesso();
	    acessoRepository.store(ultimoAcesso);
	} else {
	    tipoAcesso = ultimoAcesso.registrarAcesso();
	}

	return tipoAcesso;
    }
}
