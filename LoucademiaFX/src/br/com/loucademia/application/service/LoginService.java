package br.com.loucademia.application.service;

import java.sql.SQLException;

public interface LoginService {

    boolean existeUsuario(String login, String senha) throws SQLException;

}