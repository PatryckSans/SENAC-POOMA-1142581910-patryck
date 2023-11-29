package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Abastecimento;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Veiculo;

public class AbastecimentoDAO {
    private Connection connection;

    public AbastecimentoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserirAbastecimento(Abastecimento abastecimento) throws SQLException {
        String sql = "INSERT INTO abastecimento (data, quantidade_combustivel, preco_litro, " +
                "quilometragem, veiculo_id, combustivel, porcentagem_pre_abastecer, porcentagem_pos_abastecer) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, new java.sql.Date(abastecimento.getData().getTime()));
            preparedStatement.setDouble(2, abastecimento.getQuantidadeCombustivel());
            preparedStatement.setDouble(3, abastecimento.getPrecoLitro());
            preparedStatement.setDouble(4, abastecimento.getQuilometragem());
            preparedStatement.setInt(5, abastecimento.getVeiculo().getId());
            preparedStatement.setString(6, abastecimento.getCombustivel());
            preparedStatement.setDouble(7, abastecimento.getPorcentagemPreAbastecer());
            preparedStatement.setDouble(8, abastecimento.getPorcentagemPosAbastecer());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("A inserção do abastecimento falhou, nenhuma linha afetada.");
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    abastecimento.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("A inserção do abastecimento falhou, nenhum ID obtido.");
                }
            }
        }
    }

    public List<Abastecimento> obterTodosAbastecimentos() throws SQLException {
        List<Abastecimento> abastecimentos = new ArrayList<>();
        String sql = "SELECT * FROM abastecimento";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                abastecimentos.add(construirAbastecimento(resultSet));
            }
        }

        return abastecimentos;
    }

    private Abastecimento construirAbastecimento(ResultSet resultSet) throws SQLException {
        VeiculoDAO veiculoDAO = new VeiculoDAO(connection);
        Veiculo veiculo = veiculoDAO.obterVeiculoPorId(resultSet.getInt("veiculo_id"));

        return new Abastecimento(
                resultSet.getInt("id"),
                new java.util.Date(resultSet.getDate("data").getTime()),
                resultSet.getDouble("quantidade_combustivel"),
                resultSet.getDouble("preco_litro"),
                resultSet.getDouble("quilometragem"),
                veiculo,
                resultSet.getString("combustivel"),
                resultSet.getDouble("porcentagem_pre_abastecer"),
                resultSet.getDouble("porcentagem_pos_abastecer"));
    }
}
