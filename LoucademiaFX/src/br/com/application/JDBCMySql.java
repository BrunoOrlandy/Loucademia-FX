package br.com.application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.application.utils.LeitorScript;

public class JDBCMySql {

	private static final Logger logger = Logger.getLogger(JDBCMySql.class.getName());
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/loucademia?useTimezone=true&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1234";
	static final String LABEL_CONEXAO = "Conexão";
	private static final String PATH_SCRIPT = "./script/script.sql";

	private Connection conn;

	public Connection testaConexao() throws SQLException {
		Connection conn = null;
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			conn.setAutoCommit(false);

			if (conn != null) {
				JOptionPane.showMessageDialog(null, "Sucesso", LABEL_CONEXAO, JOptionPane.INFORMATION_MESSAGE);
			}

			return conn;

		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "falhou", LABEL_CONEXAO, JOptionPane.WARNING_MESSAGE);
			System.exit(0);
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection abreConexao() throws SQLException {
		Connection connection = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}

		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return connection;
		} catch (SQLException exception) {
			logger.log(Level.SEVERE, exception.getMessage());
		}

		return connection;
	}

	public void criaDataBase() {
		Connection conn = null;
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			conn.setAutoCommit(false);

			if (conn != null) {
				rodarScript(conn);
				JOptionPane.showMessageDialog(null, "Tabelas Criadas com sucesso!", LABEL_CONEXAO,
						JOptionPane.INFORMATION_MESSAGE);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rodarScript(Connection conn) throws SQLException {
		Statement stmt = null;
		String script = new String();
		try {

			script = LeitorScript.getConteudoArquivo(PATH_SCRIPT);
			stmt = conn.createStatement();
			String[] comandos = script.split(";");
			for (int i = 0; i < comandos.length - 1; i++) {
				stmt.execute(comandos[i]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, stmt);
		}

	}

	public static void closeAll(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.err.println("Fechada a conexão com banco de dados! ");
			}
		} catch (Exception e) {
			System.err.println("Não foi possivel fechar a conexão com o banco de dados!");
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt) {
		try {
			if (conn != null) {
				closeAll(conn);
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			System.err.println("Não foi possivel fechar o statement!");
			e.printStackTrace();
		}
	}

}
