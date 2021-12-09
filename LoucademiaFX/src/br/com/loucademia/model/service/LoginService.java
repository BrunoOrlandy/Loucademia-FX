package br.com.loucademia.model.service;

import java.sql.SQLException;

public interface LoginService {

    boolean existeUsuario(String login, String senha) throws SQLException;

}