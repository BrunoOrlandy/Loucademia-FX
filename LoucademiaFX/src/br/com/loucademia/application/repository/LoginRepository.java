package br.com.loucademia.application.repository;

import java.sql.SQLException;
import java.util.List;

import br.com.loucademia.domain.aluno.Usuario;

public interface LoginRepository {

    boolean existeUsuario(String login, String senha) throws SQLException;

    List<Usuario> findUsuario(String login, String senha) throws SQLException;
}