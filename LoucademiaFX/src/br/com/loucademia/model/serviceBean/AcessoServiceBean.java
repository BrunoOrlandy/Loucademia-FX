package br.com.loucademia.model.serviceBean;

import java.io.Serializable;
import java.sql.SQLException;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.model.enums.TipoAcesso;
import br.com.loucademia.model.repository.AcessoRepository;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AcessoRepositoryBean;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.AcessoService;
import br.com.loucademia.model.util.ValidationException;

public class AcessoServiceBean implements Serializable, AcessoService {
    AcessoRepository acessoRepository = new AcessoRepositoryBean();
    AlunoRepository alunoRepository = new AlunoRepositoryBean();

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
	    return null;
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

    @Override
    public boolean existeAluno(Integer id, String cpf) {
	Aluno a = alunoRepository.findByCPFandId(id, cpf);
	return a != null;
    }
}
