package br.com.loucademia.model.serviceBean;

import java.util.ArrayList;
import java.util.List;

import br.com.loucademia.model.model.Aluno;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.RelatorioSituacaoService;

public class RelatorioSituacaoServiceBean implements RelatorioSituacaoService {

    AlunoRepository alunoRepository = new AlunoRepositoryBean();

    @Override
    public List<Aluno> gerarRelatorio(Integer id, String situacao) {
	List<Aluno> alunos = new ArrayList<Aluno>();

	if (id == null && (situacao == null || situacao.isBlank())) {
	    alunos = alunoRepository.findAll();
	} else {
	    alunos = alunoRepository.listSituacoesAlunos(id, situacao);
	}
	return alunos;
    }

    @Override
    public List<Aluno> listaAlunosById(Integer id) {
	return alunoRepository.listaAlunosById(id);
    }

}
