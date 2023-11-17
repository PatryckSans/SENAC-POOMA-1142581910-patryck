package POOMA_ENTREGAS.ImplementacaoPI.Parte2;

public class Abastecimento {
    private String data;
    private double quantidadeCombustivel;
    private double precoLitro;
    private double quilometragem;
    private Veiculo veiculo;

    public Abastecimento(String data, double quantidadeCombustivel, double precoLitro, double quilometragem,
            Veiculo veiculo) {
        this.data = data;
        this.quantidadeCombustivel = quantidadeCombustivel;
        this.precoLitro = precoLitro;
        this.quilometragem = quilometragem;
        this.veiculo = veiculo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
}
