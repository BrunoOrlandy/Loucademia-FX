package br.com.loucademia.model.serviceBean;

import java.util.List;

import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.PesquisaAlunoService;
import br.com.loucademia.model.util.ValidationException;

public class PesquisaAlunoServiceBean implements PesquisaAlunoService {

    private AlunoRepositoryBean alunoRepository = new AlunoRepositoryBean();

    public String pesquisar(Integer matricula, String nome, Integer rg, String telefone) {

	try {
	    List<Aluno> alunos = alunoRepository.listAlunos(matricula, nome, rg, telefone);
	} catch (ValidationException e) {
	    return null;
	}
	return null;
    }

    public String excluir(Integer id) {

	alunoRepository.removeById(id);
	return "Excluido com sucesso";
    }

    public List<Aluno> buscarAluno(Aluno alunoPesquisa) {
	return alunoRepository.listAlunos(alunoPesquisa);

    }
}
