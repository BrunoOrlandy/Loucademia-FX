package br.com.loucademia.model.serviceBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.AlunoService;
import br.com.loucademia.model.util.StringUtils;
import br.com.loucademia.model.util.Validation;
import br.com.loucademia.model.util.ValidationException;

public class AlunoServiceBean implements AlunoService {

    private AlunoRepository alunoRepository = new AlunoRepositoryBean();

    @Override
    public String validarAlunoESalvar(Aluno aluno) {

	Aluno alunoEncontrado = alunoRepository.findByCPF(aluno.getCpf());
	if (alunoEncontrado == null) {
	    gravar(aluno);
	    return "Aluno: " + aluno.getNome() + " gravado com sucesso;";
	}
	return "Aluno ja existe";
    }

    @Override
    public boolean isCPFjaInformado(Aluno aluno) {
	Aluno alunoEncontrado = alunoRepository.findByCPF(aluno.getCpf());
	return alunoEncontrado == null;
    }

    @Override
    public Aluno buscarAlunoById(Integer id) {
	Aluno aluno = new Aluno();
	if (id != null) {
	    aluno = alunoRepository.findById(id);
	}
	return aluno;
    }

    @Override
    public void deleteById(Integer id) {
	alunoRepository.removeById(id);
    }

    @Override
    public Aluno findByCPF(String cpf) {
	return alunoRepository.findByCPF(cpf);
    }

    @Override
    public List<Aluno> listAlunos(Integer matricula, String nome, Integer rg, String telefone) {

	if (matricula != null && StringUtils.isEmpty(nome) && rg == null && StringUtils.isEmpty(telefone)) {
	    throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
	}

	return alunoRepository.listAlunos(matricula, nome, rg, telefone);
    }

    @Override
    public List<Aluno> listSituacoesAlunos(String situacao) {
	Validation.assertionNotEmpty(situacao);
	return alunoRepository.listSituacoesAlunos(situacao);
    }

    @Override
    public List<Acesso> listAcessosAlunos(Integer id, LocalDate dataInicial, LocalDate dataFinal) {
	if (id == null && dataInicial == null && dataFinal == null) {
	    throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
	}
	return alunoRepository.listAcessosAlunos(id, dataInicial, dataFinal);
    }

    @Override
    public String gravar(Aluno aluno) {
	try {
	    if (aluno.getId() == null) {
		alunoRepository.persist(aluno);
	    } else {
		alunoRepository.update(aluno);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return null;
    }

    @Override
    public void deletarAluno(Aluno aluno) {
	alunoRepository.remove(aluno);
    }

}
