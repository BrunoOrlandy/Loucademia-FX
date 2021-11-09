package br.com.loucademia.application.serviceBean;

import java.sql.SQLException;

import br.com.loucademia.application.repository.AcessoRepository;
import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public class AcessoServiceBean {

    private AcessoRepository acessoRepository;

    private AlunoRepository alunoRepository;

    public TipoAcesso registrarAcesso(String matricula, Integer rg) throws SQLException {

	if (StringUtils.isEmpty(matricula) && rg == null) {
	    throw new ValidationException("� preciso fornecer a matr�cula ou o RG do aluno");
	}

	Aluno aluno;
	if (StringUtils.isEmpty(matricula)) {
	    aluno = alunoRepository.findByCPF(rg);
	} else {
	    aluno = alunoRepository.findById(matricula);
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
