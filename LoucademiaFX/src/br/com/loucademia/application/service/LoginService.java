package br.com.loucademia.application.service;

import java.sql.SQLException;

import br.com.loucademia.application.repository.LoginRepository;

public class LoginService {

	LoginRepository repository = new LoginRepository();

	public boolean existeUsuario(String login, String senha) {
		boolean result = false;
		try {
			result = repository.existeUsuario(login, senha);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
