package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Veiculo;

public class VeiculoDAO {
    private Connection connection;

    public VeiculoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO veiculo (modelo, ano, placa, consumo_medio, combustivel, capacidade_tanque, senha) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, veiculo.getModelo());
            preparedStatement.setInt(2, veiculo.getAno());
            preparedStatement.setString(3, veiculo.getPlaca());
            preparedStatement.setDouble(4, veiculo.getConsumoMedio());
            preparedStatement.setString(5, veiculo.getCombustivel());
            preparedStatement.setDouble(6, veiculo.getCapacidadeTanque());
            preparedStatement.setString(7, veiculo.getSenha());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("A inserção do veículo falhou, nenhuma linha afetada.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    veiculo.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("A inserção do veículo falhou, nenhum ID obtido.");
                }
            }
        }
    }

    public Veiculo obterVeiculoPorId(int veiculoId) throws SQLException {
        String sql = "SELECT * FROM veiculo WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, veiculoId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return construirVeiculo(resultSet);
                }
            }
        }

        return null;
    }

    public List<Veiculo> obterTodosVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                veiculos.add(construirVeiculo(resultSet));
            }
        }

        return veiculos;
    }

    private Veiculo construirVeiculo(ResultSet resultSet) throws SQLException {
        return new Veiculo(
                resultSet.getInt("id"),
                resultSet.getString("modelo"),
                resultSet.getInt("ano"),
                resultSet.getString("placa"),
                resultSet.getDouble("consumo_medio"),
                resultSet.getString("combustivel"),
                resultSet.getDouble("capacidade_tanque"),
                resultSet.getString("senha"));
    }
}
