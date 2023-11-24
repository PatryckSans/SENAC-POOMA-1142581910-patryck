package POOMA_ENTREGAS.ImplementacaoPI.ParteTeste;

public class ControladorAbastecimento {
    private InterfaceUsuario interfaceUsuario;

    public ControladorAbastecimento(InterfaceUsuario interfaceUsuario) {
        this.interfaceUsuario = interfaceUsuario;
    }

    public void registrarAbastecimento() {
        String data = interfaceUsuario.lerString("Data do abastecimento");
        double quantidadeCombustivel = interfaceUsuario.lerDouble("Quantidade de combustível (litros)");
        double precoLitro = interfaceUsuario.lerDouble("Preço por litro");
        double quilometragem = interfaceUsuario.lerDouble("Quilometragem no momento do abastecimento");

        Veiculo veiculo = new Veiculo("Modelo", 2022, "ABC1234", 12.5);

        Abastecimento abastecimento = new Abastecimento(data, quantidadeCombustivel, precoLitro, quilometragem,
                veiculo);

        System.out.println("Abastecimento registrado com sucesso!");
        System.out.println("Detalhes do Abastecimento:");
        System.out.println("Data: " + abastecimento.getData());
        System.out.println("Quantidade de Combustível: " + abastecimento.getQuantidadeCombustivel() + " litros");
        System.out.println("Preço por Litro: R$ " + abastecimento.getPrecoLitro());
        System.out.println("Quilometragem: " + abastecimento.getQuilometragem() + " km");
        System.out.println("Veículo: " + abastecimento.getVeiculo().getModelo() + " ("
                + abastecimento.getVeiculo().getPlaca() + ")");
    }
}
