package br.com.loucademia.application.serviceBean;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.loucademia.application.repository.AcessoRepository;
import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.service.ControleAcessoService;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public class ControleAcessoServiceBean implements Serializable, ControleAcessoService {
    private AcessoRepository acessoRepository;
    private AlunoRepository alunoRepository;

    private static final long serialVersionUID = 1L;

    @Override
    public TipoAcesso registrarAcesso(Integer id, String cpf) {

	Aluno aluno;
	if (id == null) {
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

	    try {
		acessoRepository.persist(ultimoAcesso);

	    } catch (SQLException e) {
		e.printStackTrace();
	    }

	} else {
	    tipoAcesso = ultimoAcesso.registrarAcesso();

	    try {
		acessoRepository.persist(ultimoAcesso);

	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return tipoAcesso;
    }
}
