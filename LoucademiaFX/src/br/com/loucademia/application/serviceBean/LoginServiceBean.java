package br.com.loucademia.application.serviceBean;

import java.sql.SQLException;
import java.util.List;

import br.com.loucademia.application.repositoryBean.LoginRepositoryBean;
import br.com.loucademia.application.service.LoginService;
import br.com.loucademia.domain.aluno.Usuario;

public class LoginServiceBean implements LoginService {

    LoginRepositoryBean repository = new LoginRepositoryBean();

    @Override
    public boolean existeUsuario(String login, String senha) throws SQLException {
	List<Usuario> usuarioEncontrado = repository.findUsuario(login, senha);

	for (Usuario u : usuarioEncontrado) {
	    if (u.getLogin().equals(login)) {
		return true;
	    }
	    return false;
	}
	return false;
    }

}
