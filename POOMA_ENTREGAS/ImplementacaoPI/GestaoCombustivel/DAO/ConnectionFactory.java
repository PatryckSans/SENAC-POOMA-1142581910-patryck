package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gestao_combustivel?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "MySQL@";

    // Método para obter uma conexão com o banco de dados
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
