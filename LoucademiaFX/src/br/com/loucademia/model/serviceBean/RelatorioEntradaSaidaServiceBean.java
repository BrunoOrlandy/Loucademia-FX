package br.com.loucademia.model.serviceBean;

import java.time.LocalDate;
import java.util.List;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.repository.AlunoRepository;
import br.com.loucademia.model.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.model.service.AlunoService;
import br.com.loucademia.model.service.RelatorioEntradaSaidaService;
import br.com.loucademia.model.util.StringUtils;
import br.com.loucademia.model.util.ValidationException;

public class RelatorioEntradaSaidaServiceBean implements RelatorioEntradaSaidaService {

    private AlunoRepository alunoRepository = new AlunoRepositoryBean();

//    public void carregarAluno() {
//	if (id != null) {
//	    gerarRelatorio();
//	}
//    }

    @Override
    public List<Acesso> gerarRelatorio(Integer id, LocalDate dataInicial, LocalDate dataFinal) {
	try {
	    List<Acesso> acessos = alunoRepository.listAcessosAlunos(id, dataInicial, dataFinal);
	} catch (ValidationException e) {
	    e.printStackTrace();
	}
	return null;
    }

}
