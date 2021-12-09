package br.com.loucademia.application.service;

import java.sql.SQLException;

import br.com.loucademia.domain.acesso.TipoAcesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface ControleAcessoService {

    TipoAcesso registrarAcesso(Integer id, String cpf);
    
    boolean existeAluno(Integer id, String cpf);
    
    
}
