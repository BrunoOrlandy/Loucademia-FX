package br.com.loucademia.model.serviceBean;

import java.util.List;

import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.PesquisaAlunoService;
import br.com.loucademia.model.util.ValidationException;

public class PesquisaAlunoServiceBean implements PesquisaAlunoService {

    AlunoRepository alunoRepository = new AlunoRepositoryBean();

    @Override
    public String pesquisar(Integer matricula, String nome, Integer rg, String telefone) {

	try {
	    List<Aluno> alunos = alunoRepository.listAlunos(matricula, nome, rg, telefone);
	} catch (ValidationException e) {
	    return null;
	}
	return null;
    }

    @Override
    public String excluir(Integer id) {

	alunoRepository.removeById(id);
	return "Excluido com sucesso";
    }

    @Override
    public List<Aluno> buscarAluno(Aluno alunoPesquisa) {
	return alunoRepository.listAlunos(alunoPesquisa);

    }
}
