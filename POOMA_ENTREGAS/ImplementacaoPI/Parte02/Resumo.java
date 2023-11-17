package POOMA_ENTREGAS.ImplementacaoPI.Parte02;

import java.util.Date;

public class Resumo {
    private Date dataInicio;
    private Date data;
    private int numeroRegistros;
    private Veiculo veiculo;
    private double quilometroPorLitro;

    public Resumo(Date dataInicio, Date data, int numeroRegistros, Veiculo veiculo, double quilometroPorLitro) {
        this.dataInicio = dataInicio;
        this.data = data;
        this.numeroRegistros = numeroRegistros;
        this.veiculo = veiculo;
        this.quilometroPorLitro = quilometroPorLitro;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getNumeroRegistros() {
        return numeroRegistros;
    }

    public void setNumeroRegistros(int numeroRegistros) {
        this.numeroRegistros = numeroRegistros;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public double getQuilometroPorLitro() {
        return quilometroPorLitro;
    }

    public void setQuilometroPorLitro(double quilometroPorLitro) {
        this.quilometroPorLitro = quilometroPorLitro;
    }
}
