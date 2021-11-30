package br.com.loucademia.application.serviceBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.application.service.AlunoService;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.Validation;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public class AlunoServiceBean implements AlunoService {

    private AlunoRepository alunoRepository = new AlunoRepositoryBean();

    @Override
    public String validarAlunoESalvar(Aluno aluno) {

		Aluno alunoEncontrado = alunoRepository.findByCPF(aluno.getCpf());
		if (alunoEncontrado != null) {
		    if (alunoEncontrado.getCpf() == aluno.getCpf()) {
				return "Aluno ja existe";
			    } else {
				gravar(aluno);
				return "Aluno :" + aluno.getNome() + " gravado com sucesso;";
		    }
		}
	
		return "";
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

    @Override
    public void deleteById(Integer id) {
    	alunoRepository.removeById(id);
    }

    private void update(Aluno aluno) {
		Validation.assertionNotEmpty(aluno);
		alunoRepository.update(aluno);
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
    public List<Acesso> listAcessosAlunos(String matricula, LocalDate dataInicial, LocalDate dataFinal) {
		if (StringUtils.isEmpty(matricula) && dataInicial == null && dataFinal == null) {
		    throw new ValidationException("Pelo menos um criterio de pesquisa deve ser fornecido");
	}

	return alunoRepository.listAcessosAlunos(matricula, dataInicial, dataFinal);
    }

    @Override
    public String gravar(Aluno aluno) {

		createOrUpdate(aluno);
		System.out.println("Registro Salvo");

		return null;
    }

    @Override
    public void deletarAluno(Aluno aluno) {
    	alunoRepository.remove(aluno);
    }

}
