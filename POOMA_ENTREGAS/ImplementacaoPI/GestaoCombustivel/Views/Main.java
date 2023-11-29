package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Controllers.Controller;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Veiculo;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/gestao_combustivel?user=root",
                    "root",
                    "MySQL@");

            Veiculo veiculo = new Veiculo(0, "Modelo", 2022, "ABC1234", 12.5, "Gasolina", 60.0, "senha123");

            Controller controller = new Controller(veiculo, connection);

            controller.iniciar();

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
