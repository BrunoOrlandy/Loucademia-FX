package br.com.loucademia.model.repository;

import java.sql.SQLException;

import br.com.loucademia.model.model.Acesso;
import br.com.loucademia.model.model.Aluno;

public interface AcessoRepository {

    Acesso findUltimoAcesso(Aluno aluno);

    void persist(Acesso ultimoAcesso) throws SQLException;

}