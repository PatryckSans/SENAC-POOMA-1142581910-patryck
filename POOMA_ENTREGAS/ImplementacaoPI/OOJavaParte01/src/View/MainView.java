package POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.View;

import java.util.Scanner;

import POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.Controller.ClienteController;
import POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.Model.Cliente;

public class MainView {
    public static void main(String[] args) {
        ClienteController clienteController = new ClienteController();
        Scanner scanner = new Scanner(System.in);

        int escolha;

        do {
            System.out.println("\n==== Menu ====");
            System.out.println("1. Inclusão");
            System.out.println("2. Exclusão");
            System.out.println("3. Consulta");
            System.out.println("4. Alteração");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    realizarInclusao(scanner, clienteController);
                    break;
                case 2:
                    realizarExclusao(scanner, clienteController);
                    break;
                case 3:
                    realizarConsulta(scanner, clienteController);
                    break;
                case 4:
                    realizarAlteracao(scanner, clienteController);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (escolha != 0);

        scanner.close();
    }

    private static void realizarInclusao(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Inclusão ====");
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite o tipo do cliente (Prata, Ouro, Bronze): ");
        String tipo = scanner.nextLine();

        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.print("Digite a renda do cliente: ");
        double renda = scanner.nextDouble();

        System.out.print("Digite o valor dos bens do cliente: ");
        double valorBens = scanner.nextDouble();

        Cliente novoCliente = new Cliente(id, tipo, nome, email, endereco, renda, valorBens);
        clienteController.incluirCliente(novoCliente);
        System.out.println("Cliente incluído com sucesso.");
    }

    private static void realizarExclusao(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Exclusão ====");
        System.out.print("Digite o ID do cliente a ser excluído: ");
        int idExcluir = scanner.nextInt();
        scanner.nextLine();

        clienteController.excluirCliente(idExcluir);
        System.out.println("Cliente excluído com sucesso.");
    }

    private static void realizarConsulta(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Consulta ====");
        System.out.print("Digite o ID do cliente a ser consultado: ");
        int idConsultar = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteConsultado = clienteController.consultarCliente(idConsultar);

        if (clienteConsultado != null) {
            System.out.println("Cliente encontrado:\n" + clienteConsultado);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void realizarAlteracao(Scanner scanner, ClienteController clienteController) {
        System.out.println("\n==== Alteração ====");
        System.out.print("Digite o ID do cliente a ser alterado: ");
        int idAlterar = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteExistente = clienteController.consultarCliente(idAlterar);

        if (clienteExistente != null) {
            System.out.print("Digite o novo tipo do cliente (Prata, Ouro, Bronze): ");
            String novoTipo = scanner.nextLine();

            System.out.print("Digite o novo nome do cliente: ");
            String novoNome = scanner.nextLine();

            System.out.print("Digite o novo email do cliente: ");
            String novoEmail = scanner.nextLine();

            System.out.print("Digite o novo endereço do cliente: ");
            String novoEndereco = scanner.nextLine();

            System.out.print("Digite a nova renda do cliente: ");
            double novaRenda = scanner.nextDouble();

            System.out.print("Digite o novo valor dos bens do cliente: ");
            double novoValorBens = scanner.nextDouble();

            Cliente clienteAtualizado = new Cliente(idAlterar, novoTipo, novoNome, novoEmail, novoEndereco, novaRenda,
                    novoValorBens);
            clienteController.alterarCliente(idAlterar, clienteAtualizado);
            System.out.println("Cliente alterado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }
}
