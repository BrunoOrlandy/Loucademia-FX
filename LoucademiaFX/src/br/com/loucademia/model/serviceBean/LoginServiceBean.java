package br.com.loucademia.model.serviceBean;

import java.sql.SQLException;
import java.util.List;

import br.com.loucademia.model.model.Usuario;
import br.com.loucademia.model.repository.LoginRepository;
import br.com.loucademia.model.repositoryBean.LoginRepositoryBean;
import br.com.loucademia.model.service.LoginService;

public class LoginServiceBean implements LoginService {

    LoginRepository repository = new LoginRepositoryBean();

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
