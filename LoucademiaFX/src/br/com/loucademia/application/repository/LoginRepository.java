package br.com.loucademia.application.repository;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loucademia.application.util.EntityManagerUtil;
import br.com.loucademia.model.Usuario;

public class LoginRepository {

    private EntityManagerUtil entityManager = new EntityManagerUtil();

//    JDBCMySql jdbcConnection = new JDBCMySql();

    public boolean existeUsuario(String login, String senha) throws SQLException {

	EntityManager emf = entityManager.getEntityManager();

	List<Usuario> u = emf.createQuery("SELECT u.login FROM usuario u WHERE u.login = :login AND u.senha = :senha")
		.setParameter("login", login).setParameter("senha", senha).getResultList();

	return u.isEmpty();

//	boolean result = false;
//	try {
//	    Connection conection = jdbcConnection.getConnection();
////			PreparedStatement st = conection;
//
//	    String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
//
//	    PreparedStatement pStatement = conection.prepareStatement(sql);
//	    pStatement.setString(1, login.toString());
//	    pStatement.setString(2, senha.toString());
//
//	    ResultSet rs = pStatement.executeQuery();
//	    result = rs.next();
//	    conection.close();
//
//	} catch (SQLException e) {
//	    e.printStackTrace();
//	}
//
//	return result;
    }

}
