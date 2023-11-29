package POOMA_ENTREGAS.ImplementacaoPI.GestaoCombustivel.Models;

import java.util.Date;

public class Resumo {
    private int id;
    private Date dataInicio;
    private Date data;
    private int numeroRegistros;
    private Veiculo veiculo;
    private double quilometroPorLitro;

    public Resumo(int id, Date dataInicio, Date data, int numeroRegistros, Veiculo veiculo,
            double quilometroPorLitro) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.data = data;
        this.numeroRegistros = numeroRegistros;
        this.veiculo = veiculo;
        this.quilometroPorLitro = quilometroPorLitro;
    }

    public int getId() {
        return id;
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
