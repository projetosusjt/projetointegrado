package br.com.projetointegrado.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection obtemConexao() throws SQLException {
		return DriverManager
				
		.getConnection("jdbc:mysql://localhost/br.com.projetointegrado.conexao?"
				+ "useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false", "root", "henrique");
		}

}
