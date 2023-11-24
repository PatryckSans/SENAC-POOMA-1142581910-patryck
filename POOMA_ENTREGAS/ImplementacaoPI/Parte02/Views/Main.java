package POOMA_ENTREGAS.ImplementacaoPI.Parte02.Views;

import POOMA_ENTREGAS.ImplementacaoPI.Parte02.Controllers.Controller;
import POOMA_ENTREGAS.ImplementacaoPI.Parte02.Models.Veiculo;

public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Modelo", 2022, "ABC1234", 12.5, "Gasolina", 60.0, "senha123");
        Controller controller = new Controller(veiculo);
        controller.iniciar();
    }
}
