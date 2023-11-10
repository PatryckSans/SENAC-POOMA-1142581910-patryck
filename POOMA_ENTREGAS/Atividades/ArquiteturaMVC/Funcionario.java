package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

public class Funcionario {
    private String nome;
    private String departamento;
    private String funcao;
    private double salario;

    public Funcionario(String nome, String departamento, String funcao, double salario) {
        this.nome = nome;
        this.departamento = departamento;
        this.funcao = funcao;
        this.salario = salario;
    }

    public double calcularPagamento() {
        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
