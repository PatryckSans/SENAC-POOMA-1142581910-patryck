package POOMA_ENTREGAS.ImplementacaoPI.Parte02.Models;

import java.util.Date;

public class Abastecimento {
    private Date data;
    private double quantidadeCombustivel;
    private double precoLitro;
    private double quilometragem;
    private Veiculo veiculo;
    private String combustivel;
    private double porcentagemPreAbastecer;
    private double porcentagemPosAbastecer;

    public Abastecimento(Date data, double quantidadeCombustivel, double precoLitro, double quilometragem,
            Veiculo veiculo, String combustivel, double porcentagemPreAbastecer, double porcentagemPosAbastecer) {
        this.data = data;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.precoLitro = precoLitro;
        this.quilometragem = quilometragem;
        this.veiculo = veiculo;
        this.combustivel = combustivel;
        this.porcentagemPreAbastecer = porcentagemPreAbastecer;
        this.porcentagemPosAbastecer = porcentagemPosAbastecer;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQuantidadeCombustivel() {
        return quantidadeCombustivel;
    }

    public void setQuantidadeCombustivel(double quantidadeCombustivel) {
        this.quantidadeCombustivel = quantidadeCombustivel;
    }

    public double getPrecoLitro() {
        return precoLitro;
    }

    public void setPrecoLitro(double precoLitro) {
        this.precoLitro = precoLitro;
    }

    public double getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(double quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getPorcentagemPreAbastecer() {
        return porcentagemPreAbastecer;
    }

    public void setPorcentagemPreAbastecer(double porcentagemPreAbastecer) {
        this.porcentagemPreAbastecer = porcentagemPreAbastecer;
    }

    public double getPorcentagemPosAbastecer() {
        return porcentagemPosAbastecer;
    }

    public void setPorcentagemPosAbastecer(double porcentagemPosAbastecer) {
        this.porcentagemPosAbastecer = porcentagemPosAbastecer;
    }
}
