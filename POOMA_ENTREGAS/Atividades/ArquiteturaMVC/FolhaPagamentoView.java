package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

import java.util.Scanner;

public class FolhaPagamentoView {
    private Scanner scanner;

    public FolhaPagamentoView() {
        this.scanner = new Scanner(System.in);
    }

    public Funcionario lerFuncionario() {
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Departamento: ");
        String departamento = scanner.nextLine();
        System.out.print("Função: ");
        String funcao = scanner.nextLine();
        System.out.print("Tipo de funcionário (Horista/Mensalista/Tarefeiro): ");
        String tipo = scanner.nextLine();

        if (tipo.equalsIgnoreCase("Horista")) {
            System.out.print("Horas trabalhadas: ");
            double horasTrabalhadas = scanner.nextDouble();
            System.out.print("Valor da hora: ");
            double valorHora = scanner.nextDouble();
            return new Horista(nome, departamento, funcao, horasTrabalhadas, valorHora);
        } else if (tipo.equalsIgnoreCase("Mensalista")) {
            System.out.print("Salário fixo: ");
            double salarioFixo = scanner.nextDouble();
            return new Mensalista(nome, departamento, funcao, salarioFixo);
        } else if (tipo.equalsIgnoreCase("Tarefeiro")) {
            System.out.print("Quantidade de tarefas: ");
            int quantidadeTarefas = scanner.nextInt();
            System.out.print("Valor da tarefa: ");
            double valorTarefa = scanner.nextDouble();
            return new Tarefeiro(nome, departamento, funcao, quantidadeTarefas, valorTarefa);
        } else {
            System.out.println("Tipo de funcionário inválido");
            return null;
        }
    }

    public Scanner getScanner() {
        return scanner;
    }
}
