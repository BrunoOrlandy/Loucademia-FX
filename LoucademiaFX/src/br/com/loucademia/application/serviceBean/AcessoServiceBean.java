package br.com.loucademia.application.serviceBean;

import java.sql.SQLException;

import br.com.loucademia.application.repository.AcessoRepository;
import br.com.loucademia.application.repository.AlunoRepository;
import br.com.loucademia.application.repositoryBean.AcessoRepositoryBean;
import br.com.loucademia.application.repositoryBean.AlunoRepositoryBean;
import br.com.loucademia.application.util.StringUtils;
import br.com.loucademia.application.util.ValidationException;
import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AcessoServiceBean {

    private AcessoRepositoryBean acessoRepository = new AcessoRepositoryBean();
    private AlunoRepositoryBean alunoRepository = new AlunoRepositoryBean();

    public TipoAcesso registrarAcesso(Integer id, String cpf) {
    	
    	TipoAcesso tipoAcesso = null;
    	Alert alert = new Alert(AlertType.INFORMATION);
	
		Aluno aluno;
		if (id == null) {
		    aluno = alunoRepository.findByCPF(cpf);
		    
		} else {
		    aluno = alunoRepository.findById(id);
		}
	
		if (aluno == null) {
		    alert.setContentText("O aluno nao foi encontrato");
		    alert.show();
		    
		} else {
			Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
		
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
			}
		}
		
		return tipoAcesso;
    }
}
