package POOMA_ENTREGAS.ImplementacaoPI.Parte02;

import java.util.ArrayList;
import java.util.List;

public class Veiculo {
    private String modelo;
    private int ano;
    private String placa;
    private double consumoMedio;
    private String combustivel;
    private double capacidadeTanque;
    private String senha;
    private List<Abastecimento> abastecimentos;

    public Veiculo(String modelo, int ano, String placa, double consumoMedio, String combustivel,
            double capacidadeTanque, String senha) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.consumoMedio = consumoMedio;
        this.combustivel = combustivel;
        this.capacidadeTanque = capacidadeTanque;
        this.senha = senha;
        this.abastecimentos = new ArrayList<>();
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void adicionarAbastecimento(Abastecimento abastecimento) {
        abastecimentos.add(abastecimento);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
