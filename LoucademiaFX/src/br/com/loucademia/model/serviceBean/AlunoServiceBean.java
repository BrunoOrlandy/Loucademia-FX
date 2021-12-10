package br.com.loucademia.model.serviceBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.AlunoService;
import br.com.loucademia.model.util.StringUtils;
import br.com.loucademia.model.util.Validation;
import br.com.loucademia.model.util.ValidationException;

public class AlunoServiceBean implements AlunoService {

    AlunoRepository alunoRepository = new AlunoRepositoryBean();

    @Override
    public String validarAlunoESalvar(Aluno aluno) {

	String mensagem = new String();

	List<Aluno> listaDealunos = alunoRepository.findAlunoByCPF(aluno.getCpf());
	for (Aluno alunoExistente : listaDealunos) {
	    if (aluno.getId() == null && alunoExistente.getCpf().equals(aluno.getCpf())) {
		mensagem = "Aluno já existe";
	    }
	}

	for (Aluno alunoExistente : listaDealunos) {
	    if (alunoExistente.getId() == aluno.getId() && alunoExistente.getCpf().equals(aluno.getCpf())) {
		mensagem = gravar(aluno);
	    }
	}

	if (listaDealunos == null || listaDealunos.isEmpty()) {
	    mensagem = gravar(aluno);
	}
	return mensagem;
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
    public List<Aluno> listSituacoesAlunos(Integer id, String situacao) {
	return alunoRepository.listSituacoesAlunos(id, situacao);
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
	} catch (SQLException sql) {
	    sql.printStackTrace();
	    return "Erro ao Salvar";
	} catch (Exception e) {
	    e.printStackTrace();
	    return "Erro ao Salvar";
	}
	return "Sucesso";
    }

    @Override
    public void deletarAluno(Aluno aluno) {
	alunoRepository.remove(aluno);
    }

}
