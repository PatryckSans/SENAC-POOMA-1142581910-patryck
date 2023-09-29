import java.util.Scanner;

class Funcionario {
    private String nome;
    private String departamento;
    private String funcao;
    protected double salario;

    public Funcionario(String nome, String departamento, String funcao) {
        this.nome = nome;
        this.departamento = departamento;
        this.funcao = funcao;
    }

    public void calcularSalario() {
    }

    public void imprimirComprovante() {
        System.out.println("Nome: " + nome);
        System.out.println("Departamento: " + departamento);
        System.out.println("Função: " + funcao);
        System.out.println("Salário: R$" + salario);
    }
}

class Horista extends Funcionario {
    private double horasTrabalhadas;
    private double valorHora;

    public Horista(String nome, String departamento, String funcao, double horasTrabalhadas, double valorHora) {
        super(nome, departamento, funcao);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
        calcularSalario();
    }

    @Override
    public void calcularSalario() {
        salario = horasTrabalhadas * valorHora;
    }
}

class Mensalista extends Funcionario {
    private double salarioMensal;

    public Mensalista(String nome, String departamento, String funcao, double salarioMensal) {
        super(nome, departamento, funcao);
        this.salarioMensal = salarioMensal;
        calcularSalario();
    }

    @Override
    public void calcularSalario() {
        salario = salarioMensal;
    }
}

class Tarefeiro extends Funcionario {
    private int quantidadeTarefas;
    private double valorTarefa;

    public Tarefeiro(String nome, String departamento, String funcao, int quantidadeTarefas, double valorTarefa) {
        super(nome, departamento, funcao);
        this.quantidadeTarefas = quantidadeTarefas;
        this.valorTarefa = valorTarefa;
        calcularSalario();
    }

    @Override
    public void calcularSalario() {
        salario = quantidadeTarefas * valorTarefa;
    }
}

public class FolhaDePagamento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o departamento: ");
        String departamento = scanner.nextLine();

        System.out.print("Digite a função (Horista/Mensalista/Tarefeiro): ");
        String funcao = scanner.nextLine();

        if (funcao.equalsIgnoreCase("Horista")) {
            System.out.print("Digite as horas trabalhadas: ");
            double horasTrabalhadas = scanner.nextDouble();
            System.out.print("Digite o valor da hora: ");
            double valorHora = scanner.nextDouble();

            Horista horista = new Horista(nome, departamento, funcao, horasTrabalhadas, valorHora);
            horista.imprimirComprovante();
        } else if (funcao.equalsIgnoreCase("Mensalista")) {
            System.out.print("Digite o salário mensal: ");
            double salarioMensal = scanner.nextDouble();

            Mensalista mensalista = new Mensalista(nome, departamento, funcao, salarioMensal);
            mensalista.imprimirComprovante();
        } else if (funcao.equalsIgnoreCase("Tarefeiro")) {
            System.out.print("Digite a quantidade de tarefas realizadas: ");
            int quantidadeTarefas = scanner.nextInt();
            System.out.print("Digite o valor da tarefa: ");
            double valorTarefa = scanner.nextDouble();

            Tarefeiro tarefeiro = new Tarefeiro(nome, departamento, funcao, quantidadeTarefas, valorTarefa);
            tarefeiro.imprimirComprovante();
        } else {
            System.out.println("Função inválida.");
        }

        scanner.close();
    }
}
