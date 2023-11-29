package POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Abastecimento;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Veiculo;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.model.Posto;

public class AbastecimentoController {

    private List<Abastecimento> abastecimentos;

    public AbastecimentoController() {
        this.abastecimentos = new ArrayList<>();
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void adicionarAbastecimento(Veiculo veiculo, Posto posto, Date data, double quantidadeLitros,
            double quilometrosOdometro, double preco, String tipoCombustivel) {
        Abastecimento abastecimento = new Abastecimento(veiculo, posto, data, quantidadeLitros, quilometrosOdometro,
                preco,
                tipoCombustivel);
        abastecimentos.add(abastecimento);
    }

    public void adicionarVeiculo(String placa, String marca, String modelo) {
        new Veiculo(placa, marca, modelo);
    }

    public double calcularMediaKmPorLitro(Veiculo veiculo) {
        double somaKmPorLitro = 0.0;
        int totalAbastecimentos = 0;

        for (Abastecimento abastecimento : abastecimentos) {
            if (abastecimento.getVeiculo().equals(veiculo) && abastecimento.getQuantidadeLitros() > 0) {
                somaKmPorLitro += abastecimento.getQuilometrosOdometro() / abastecimento.getQuantidadeLitros();
                totalAbastecimentos++;
            }
        }

        return totalAbastecimentos > 0 ? somaKmPorLitro / totalAbastecimentos : 0.0;
    }
}
