package br.com.fiap.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/Cadastro?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
