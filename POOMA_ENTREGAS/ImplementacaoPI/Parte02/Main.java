package POOMA_ENTREGAS.ImplementacaoPI.Parte02;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Modelo", 2022, "ABC1234", 12.5, "Gasolina", 60.0, "senha123");

        if (loginVeiculo(veiculo, "ABC1234", "senha123")) {
            Abastecimento abastecimento1 = criarAbastecimento(veiculo);
            Abastecimento abastecimento2 = criarAbastecimento(veiculo);

            listarAbastecimentos(veiculo);

            listarInformacoesVeiculo(veiculo);

            criarResumo(veiculo);

        } else {
            System.out.println("Login falhou. Placa ou senha incorretas.");
        }
    }

    private static boolean loginVeiculo(Veiculo veiculo, String placa, String senha) {
        return veiculo.getPlaca().equals(placa) && veiculo.getSenha().equals(senha);
    }

    private static Abastecimento criarAbastecimento(Veiculo veiculo) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Informe a data do abastecimento (formato dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            Date data = null;
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                data = dateFormat.parse(dataStr);
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Informe a quantidade de combustível abastecida: ");
            double quantidadeCombustivel = scanner.nextDouble();

            System.out.println("Informe o preço por litro: ");
            double precoLitro = scanner.nextDouble();

            System.out.println("Informe a quilometragem no momento do abastecimento: ");
            double quilometragem = scanner.nextDouble();

            System.out.println("Informe o tipo de combustível: ");
            String combustivel = scanner.next();

            System.out.println("Informe a porcentagem antes de abastecer: ");
            double porcentagemPreAbastecer = scanner.nextDouble();

            System.out.println("Informe a porcentagem depois de abastecer: ");
            double porcentagemPosAbastecer = scanner.nextDouble();

            Abastecimento abastecimento = new Abastecimento(data, quantidadeCombustivel, precoLitro, quilometragem,
                    veiculo,
                    combustivel, porcentagemPreAbastecer, porcentagemPosAbastecer);
            veiculo.adicionarAbastecimento(abastecimento);

            return abastecimento;
        }
    }

    private static void listarAbastecimentos(Veiculo veiculo) {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();

        if (abastecimentos.size() > 0) {
            System.out.println("\nRegistros de Abastecimento:");
            for (Abastecimento abastecimento : abastecimentos) {
                System.out.println("Data: " + abastecimento.getData());
                System.out.println("Quantidade de Combustível: " + abastecimento.getQuantidadeCombustivel());
                System.out.println("Preço por Litro: " + abastecimento.getPrecoLitro());
                System.out.println("Quilometragem: " + abastecimento.getQuilometragem());
                System.out.println("Tipo de Combustível: " + abastecimento.getCombustivel());
                System.out.println("Porcentagem antes de abastecer: " + abastecimento.getPorcentagemPreAbastecer());
                System.out.println("Porcentagem depois de abastecer: " + abastecimento.getPorcentagemPosAbastecer());
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Não há registros de abastecimento para listar.");
        }
    }

    private static void listarInformacoesVeiculo(Veiculo veiculo) {
        System.out.println("\nInformações do Veículo:");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Combustível: " + veiculo.getCombustivel());
        System.out.println("Consumo Médio: " + veiculo.getConsumoMedio());
        System.out.println("Capacidade do Tanque: " + veiculo.getCapacidadeTanque());
    }

    private static void criarResumo(Veiculo veiculo) {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();

        if (abastecimentos.size() > 0) {
            double quilometragemTotal = abastecimentos.get(abastecimentos.size() - 1).getQuilometragem()
                    - abastecimentos.get(0).getQuilometragem();

            double quantidadeTotalCombustivel = 0.0;
            for (Abastecimento abastecimento : abastecimentos) {
                quantidadeTotalCombustivel += abastecimento.getQuantidadeCombustivel();
            }

            double consumoMedio = quilometragemTotal / quantidadeTotalCombustivel;

            Resumo resumo = new Resumo(abastecimentos.get(0).getData(),
                    abastecimentos.get(abastecimentos.size() - 1).getData(),
                    abastecimentos.size(), veiculo, consumoMedio);

            System.out.println("\nResumo:");
            System.out.println("Data Início: " + resumo.getDataInicio());
            System.out.println("Data Fim: " + resumo.getData());
            System.out.println("Número de Registros: " + resumo.getNumeroRegistros());
            System.out.println("Veículo: " + resumo.getVeiculo().getModelo());
            System.out.println("Consumo Médio: " + resumo.getQuilometroPorLitro());
        } else {
            System.out.println("Não há registros de abastecimento para criar um resumo.");
        }
    }

}
