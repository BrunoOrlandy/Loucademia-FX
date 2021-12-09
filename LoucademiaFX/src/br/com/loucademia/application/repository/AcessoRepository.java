package br.com.loucademia.application.repository;

import java.sql.SQLException;

import br.com.loucademia.domain.aluno.Acesso;
import br.com.loucademia.domain.aluno.Aluno;

public interface AcessoRepository {

    Acesso findUltimoAcesso(Aluno aluno);

	void persist(Acesso ultimoAcesso) throws SQLException;

}