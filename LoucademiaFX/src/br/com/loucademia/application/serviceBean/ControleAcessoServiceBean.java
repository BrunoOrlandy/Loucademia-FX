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

    // passar esta logica para o controller disparar a mensagem
    // não podem ser instanciadas variaveis na classe somente dentro do metodo
//    public String registrarAcesso() {
//
//	TipoAcesso tipoAcesso = registrarAcesso(matricula, rg);
//
//	String msg;
//	if (tipoAcesso == TipoAcesso.ENTRADA) {
//	    msg = "ENTRADA registrada";
//	} else {
//	    msg = "Dados de registro de acesso inconsistentes";
//	}
//
//	return msg;
//    }

    @Override
    public TipoAcesso registrarAcesso(Integer id, String cpf) {
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
