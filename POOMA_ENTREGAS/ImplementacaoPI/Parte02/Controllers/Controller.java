package POOMA_ENTREGAS.ImplementacaoPI.Parte02.Controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import POOMA_ENTREGAS.ImplementacaoPI.Parte02.Models.Abastecimento;
import POOMA_ENTREGAS.ImplementacaoPI.Parte02.Models.Resumo;
import POOMA_ENTREGAS.ImplementacaoPI.Parte02.Models.Veiculo;

public class Controller {
    private Veiculo veiculo;

    public Controller(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void iniciar() {
        if (loginVeiculo("ABC1234", "senha123")) {
            criarAbastecimento();

            listarAbastecimentos();

            listarInformacoesVeiculo();

            criarResumo();

            System.out.println("Até logoo!");

        } else {
            System.out.println("Login falhou. Placa ou senha incorretas.");
        }
    }

    private boolean loginVeiculo(String placa, String senha) {
        return veiculo.getPlaca().equals(placa) && veiculo.getSenha().equals(senha);
    }

    private void criarAbastecimento() {
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

            System.out.println("Informe a quilometragem no momento do abastecimento: ");
            double quilometragem = scanner.nextDouble();

            System.out.println("Informe o tipo de combustível: ");
            String combustivel = scanner.next();

            System.out.println("Informe o preco do litro pago no abastecimento: ");
            double precoLitro = scanner.nextDouble();

            System.out.println("Informe a porcentagem antes de abastecer: ");
            double porcentagemPreAbastecer = scanner.nextDouble();

            System.out.println("Informe a porcentagem depois de abastecer: ");
            double porcentagemPosAbastecer = scanner.nextDouble();
            scanner.close();
            Abastecimento abastecimento = new Abastecimento(
                    data,
                    quantidadeCombustivel,
                    precoLitro,
                    quilometragem,
                    veiculo,
                    combustivel,
                    porcentagemPreAbastecer,
                    porcentagemPosAbastecer);

            veiculo.adicionarAbastecimento(abastecimento);

            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("Deseja adicionar um novo abastecimento? (S/N)");
                String keep = "";
                if (scan.hasNext()) {
                    keep = scan.nextLine();
                    if (keep == "S") {
                        criarAbastecimento();
                    } else {
                        System.out.println("Até logo!");
                    }
                } else {
                    System.out.println("Erro: Nenhum tipo de valor de entrada fornecido.");
                }

            }
        }
    }

    private void listarAbastecimentos() {
        List<Abastecimento> abastecimentos = veiculo.getAbastecimentos();

        if (abastecimentos.size() > 0) {
            System.out.println("\nRegistros de Abastecimento:");
            for (Abastecimento abastecimento : abastecimentos) {
                System.out.println("Data: " + abastecimento.getData());
                System.out.println("Quantidade de Combustível: " + abastecimento.getQuantidadeCombustivel());
                System.out.println("Preço por Litro: " + abastecimento.getPrecoLitro());
                System.out.println("Quilometragem: " + abastecimento.getQuilometragem());
                System.out.println("Tipo de Combustível: " + abastecimento.getCombustivel());
            }
        } else {
            System.out.println("Não há registros de abastecimento para listar.");
        }
    }

    private void listarInformacoesVeiculo() {
        System.out.println("\nInformações do Veículo:");
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Ano: " + veiculo.getAno());
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Combustível: " + veiculo.getCombustivel());
        System.out.println("Consumo Médio: " + veiculo.getConsumoMedio());
    }

    private void criarResumo() {
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
