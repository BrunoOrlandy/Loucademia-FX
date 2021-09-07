package br.com.application.startUp;

import java.sql.SQLException;
import java.util.Locale;

import br.com.application.JDBCMySql;

public class StatUp {

	public static void main(String[] args) {

		JDBCMySql mysql = new JDBCMySql();
		mysql.criaDataBase();
	}

}
