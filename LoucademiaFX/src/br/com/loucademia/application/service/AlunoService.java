package br.com.loucademia.application.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import br.com.loucademia.domain.aluno.AlunoRepository;

public class AlunoService {

    private AlunoRepository alunoRepository = new AlunoRepository();

    public String validarAlunoESalvar(Aluno aluno) {
	try {
	    Aluno alunoEncontrado = alunoRepository.findByCPF(aluno.getCpf());

	    if (alunoEncontrado != null) {
		return "Aluno ja existe";
	    } else {
		gravar(aluno);
		return "Aluno :" + aluno.getNome() + " gravado com sucesso;";
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return "";
    }

    public Aluno buscarAlunoById(String id) {
	Aluno aluno = new Aluno();
	if (!StringUtils.isEmpty(id)) {
	    aluno = alunoRepository.findById(id);
	}
	return aluno;
    }

    public void createOrUpdate(Aluno aluno) {
	if (aluno.getId() == null) {
	    create(aluno);
	} else {
	    update(aluno);
	}
    }

    private void create(Aluno aluno) {
	try {
	    alunoRepository.persist(aluno);
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void delete(String matricula) {
	alunoRepository.removeById(matricula);
    }

    private void update(Aluno aluno) {
	Validation.assertionNotEmpty(aluno);
	alunoRepository.update(aluno);
    }

    public Aluno findByMatricula(String matricula) {
	return alunoRepository.findById(matricula);
    }

    public Aluno findByRG(Integer rg) {
	return alunoRepository.findById(rg.toString());
    }

    public List<Aluno> listAlunos(String matricula, String nome, Integer rg, Integer telefone) {

	if (StringUtils.isEmpty(matricula) && StringUtils.isEmpty(nome) && rg == null && telefone == null) {
	    throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
	}

	return alunoRepository.listAlunos(matricula, nome, rg, telefone);
    }

    public List<Aluno> listSituacoesAlunos(String situacao) {
	Validation.assertionNotEmpty(situacao);
	return alunoRepository.listSituacoesAlunos(situacao);
    }

    public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
	if (StringUtils.isEmpty(matricula) && dataInicial == null && dataFinal == null) {
	    throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
	}

	return alunoRepository.listAcessosAlunos(matricula, dataInicial, dataFinal);
    }

    public String gravar(Aluno aluno) {

	createOrUpdate(aluno);
	System.out.println("Registro Salvo");

	return null;
    }

}
