package POOMA_ENTREGAS.ImplementacaoPI.ParteTeste;

public class Veiculo {
    private String modelo;
    private int ano;
    private String placa;
    private double consumoMedio;

    public Veiculo(String modelo, int ano, String placa, double consumoMedio) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.consumoMedio = consumoMedio;
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
}
