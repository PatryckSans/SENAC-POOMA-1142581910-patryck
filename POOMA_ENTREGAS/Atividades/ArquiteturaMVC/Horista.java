package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

public class Horista extends Funcionario {
    private double horasTrabalhadas;
    private double valorHora;

    public Horista(String nome, String departamento, String funcao, double horasTrabalhadas, double valorHora) {
        super(nome, departamento, funcao, 0);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }
}
