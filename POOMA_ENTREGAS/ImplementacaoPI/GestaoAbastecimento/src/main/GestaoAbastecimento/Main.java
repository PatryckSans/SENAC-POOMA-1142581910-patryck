package POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento;

import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.controller.AbastecimentoController;
import POOMA_ENTREGAS.ImplementacaoPI.GestaoAbastecimento.src.main.GestaoAbastecimento.view.AbastecimentoView;

public class Main {

    public static void main(String[] args) {
        AbastecimentoController abastecimentoController = new AbastecimentoController();

        AbastecimentoView abastecimentoView = new AbastecimentoView(abastecimentoController);

        abastecimentoView.exibirMenu();
    }
}
