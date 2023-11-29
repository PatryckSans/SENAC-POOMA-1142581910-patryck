package POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection connection = MySQLConnector.getConnection();
                Statement statement = connection.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS abastecimento (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "veiculo_placa VARCHAR(20)," +
                    "posto_nome VARCHAR(100)," +
                    "data DATE," +
                    "quantidade_litros DOUBLE," +
                    "quilometros_odometro DOUBLE," +
                    "preco DOUBLE," +
                    "tipo_combustivel VARCHAR(50)" +
                    ");";
            statement.executeUpdate(createTableSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
