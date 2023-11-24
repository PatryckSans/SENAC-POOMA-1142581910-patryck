package POOMA_ENTREGAS.ImplementacaoPI.OOJavaParte01.src.Model;

public class Cliente {
    private int id;
    private String tipo;
    private String nome;
    private String email;
    private String endereco;
    private double renda;
    private double valorBens;
    private double valorCredito;

    public Cliente(int id, String tipo, String nome, String email, String endereco, double renda, double valorBens) {
        this.id = id;
        this.tipo = tipo;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.renda = renda;
        this.valorBens = valorBens;
        calcularCreditoPreAprovado();
    }

    private void calcularCreditoPreAprovado() {
        switch (tipo.toLowerCase()) {
            case "bronze":
                valorCredito = renda * 1.0;
                break;
            case "prata":
                valorCredito = renda * 1.5 + (valorBens * 0.01);
                break;
            case "ouro":
                valorCredito = renda * 2.5 + (valorBens * 0.9);
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente inválido");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double getValorBens() {
        return valorBens;
    }

    public void setValorBens(double valorBens) {
        this.valorBens = valorBens;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", renda=" + renda +
                ", valorBens=" + valorBens +
                ", valorCredito=" + valorCredito +
                '}';
    }
}
