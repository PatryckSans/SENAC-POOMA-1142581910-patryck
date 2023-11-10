package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

public class Tarefeiro extends Funcionario {
    private int quantidadeTarefas;
    private double valorTarefa;

    public Tarefeiro(String nome, String departamento, String funcao, int quantidadeTarefas, double valorTarefa) {
        super(nome, departamento, funcao, 0);
        this.quantidadeTarefas = quantidadeTarefas;
        this.valorTarefa = valorTarefa;
    }

    @Override
    public double calcularPagamento() {
        return quantidadeTarefas * valorTarefa;
    }
}
