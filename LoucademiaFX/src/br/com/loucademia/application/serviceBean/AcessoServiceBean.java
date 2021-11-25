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

    public TipoAcesso registrarAcesso(Integer id, String cpf) throws SQLException {

	if (id != null && cpf == null) {
	    throw new ValidationException("Necessario informar a matricula ou cpf");
	}

	Aluno aluno;
	if (id != null) {
	    aluno = alunoRepository.findByCPF(cpf);
	} else {
	    aluno = alunoRepository.findById(id);
	}

	if (aluno == null) {
	    throw new ValidationException("O aluno não foi encontrado");
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
