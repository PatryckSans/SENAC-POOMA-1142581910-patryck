package POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.controller.AbastecimentoController;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Abastecimento;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Posto;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Veiculo;

public class AbastecimentoView {

    private AbastecimentoController abastecimentoController;
    private Scanner scanner;
    private SimpleDateFormat dateFormat;

    public AbastecimentoView(AbastecimentoController abastecimentoController) {
        this.abastecimentoController = abastecimentoController;
        this.scanner = new Scanner(System.in);
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Adicionar Abastecimento");
            System.out.println("2. Exibir Lista de Abastecimentos");
            System.out.println("3. Calcular Média de Km por Litro");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAbastecimento();
                    break;
                case 2:
                    exibirListaAbastecimentos();
                    break;
                case 3:
                    calcularMediaKmPorLitro();
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void adicionarAbastecimento() {
        System.out.println("----- Adicionar Abastecimento -----");

        System.out.print("Placa do Veículo: ");
        String placaVeiculo = scanner.nextLine();
        Veiculo veiculo = obterVeiculoPorPlaca(placaVeiculo);

        if (veiculo == null) {
            System.out.print("Marca do Veículo: ");
            String marcaVeiculo = scanner.nextLine();
            System.out.print("Modelo do Veículo: ");
            String modeloVeiculo = scanner.nextLine();
            abastecimentoController.adicionarVeiculo(placaVeiculo, marcaVeiculo, modeloVeiculo);
        }

        System.out.print("Nome do Posto: ");
        String nomePosto = scanner.nextLine();
        System.out.print("Localização do Posto: ");
        String localizacaoPosto = scanner.nextLine();
        Posto posto = obterPosto(nomePosto, localizacaoPosto);

        if (posto == null) {
            System.out.println("Posto não encontrado. Adicione o posto antes de continuar.");
            return;
        }

        System.out.print("Data do Abastecimento (yyyy-MM-dd): ");
        String dataAbastecimentoStr = scanner.nextLine();
        Date dataAbastecimento = parseDate(dataAbastecimentoStr);

        System.out.print("Quantidade de Litros: ");
        double quantidadeLitros = scanner.nextDouble();

        System.out.print("Quilômetros no Odômetro: ");
        double quilometrosOdometro = scanner.nextDouble();

        System.out.print("Preço por Litro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Tipo de Combustível: ");
        String tipoCombustivel = scanner.nextLine();

        abastecimentoController.adicionarAbastecimento(veiculo, posto, dataAbastecimento, quantidadeLitros,
                quilometrosOdometro, preco, tipoCombustivel);
        System.out.println("Abastecimento adicionado com sucesso!");
    }

    private void exibirListaAbastecimentos() {
        System.out.println("----- Lista de Abastecimentos -----");

        List<Abastecimento> abastecimentos = abastecimentoController.getAbastecimentos();
        if (abastecimentos.isEmpty()) {
            System.out.println("Nenhum abastecimento encontrado.");
        } else {
            for (Abastecimento abastecimento : abastecimentos) {
                System.out.println(abastecimento);
            }
        }
    }

    private void calcularMediaKmPorLitro() {
        System.out.println("----- Calcular Média de Km por Litro -----");

        System.out.print("Placa do Veículo: ");
        String placaVeiculo = scanner.nextLine();
        Veiculo veiculo = obterVeiculoPorPlaca(placaVeiculo);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado.");
            return;
        }

        double media = abastecimentoController.calcularMediaKmPorLitro(veiculo);
        System.out.println("Média de Km por Litro: " + media);
    }

    private Veiculo obterVeiculoPorPlaca(String placa) {
        return null;
    }

    private Posto obterPosto(String nome, String localizacao) {
        return null;
    }

    private Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Erro ao converter data. Certifique-se de usar o formato yyyy-MM-dd.");
            return null;
        }
    }
}
