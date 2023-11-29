package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Resumo;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models.Veiculo;

public class ResumoDAO {
    private Connection connection;

    // Construtor que recebe uma conexão para ser reutilizada
    public ResumoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para inserir um resumo no banco de dados
    public void inserirResumo(Resumo resumo) throws SQLException {
        String sql = "INSERT INTO resumo (data_inicio, data, numero_registros, veiculo_id, quilometro_por_litro) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setDate(1, new java.sql.Date(resumo.getDataInicio().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(resumo.getData().getTime()));
            preparedStatement.setInt(3, resumo.getNumeroRegistros());
            preparedStatement.setInt(4, resumo.getVeiculo().getId());
            preparedStatement.setDouble(5, resumo.getQuilometroPorLitro());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("A inserção do resumo falhou, nenhuma linha afetada.");
            }
        }
    }

    // Método para obter todos os resumos do banco de dados
    public List<Resumo> obterTodosResumos() throws SQLException {
        List<Resumo> resumos = new ArrayList<>();
        String sql = "SELECT * FROM resumo";

        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                resumos.add(construirResumo(resultSet));
            }
        }

        return resumos;
    }

    // Método auxiliar para construir um objeto Resumo a partir do ResultSet
    private Resumo construirResumo(ResultSet resultSet) throws SQLException {
        VeiculoDAO veiculoDAO = new VeiculoDAO(connection);
        Veiculo veiculo = veiculoDAO.obterVeiculoPorId(resultSet.getInt("veiculo_id"));

        return new Resumo(
                resultSet.getInt("id"),
                new java.util.Date(resultSet.getDate("data_inicio").getTime()),
                new java.util.Date(resultSet.getDate("data").getTime()),
                resultSet.getInt("numero_registros"),
                veiculo,
                resultSet.getDouble("quilometro_por_litro"));
    }
}
