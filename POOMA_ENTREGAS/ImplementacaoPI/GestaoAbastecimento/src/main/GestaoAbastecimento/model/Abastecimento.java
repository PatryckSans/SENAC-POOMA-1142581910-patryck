package POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model;

import java.util.Date;

public class Abastecimento {
    private Veiculo veiculo;
    private Posto posto;
    private Date data;
    private double quantidadeLitros;
    private double quilometrosOdometro;
    private double preco;
    private String tipoCombustivel;

    public Abastecimento(Veiculo veiculo, Posto posto, Date data, double quantidadeLitros, double quilometrosOdometro,
            double preco, String tipoCombustivel) {
        this.veiculo = veiculo;
        this.posto = posto;
        this.data = data;
        this.quantidadeLitros = quantidadeLitros;
        this.quilometrosOdometro = quilometrosOdometro;
        this.preco = preco;
        this.tipoCombustivel = tipoCombustivel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQuantidadeLitros() {
        return quantidadeLitros;
    }

    public void setQuantidadeLitros(double quantidadeLitros) {
        this.quantidadeLitros = quantidadeLitros;
    }

    public double getQuilometrosOdometro() {
        return quilometrosOdometro;
    }

    public void setQuilometrosOdometro(double quilometrosOdometro) {
        this.quilometrosOdometro = quilometrosOdometro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
}
