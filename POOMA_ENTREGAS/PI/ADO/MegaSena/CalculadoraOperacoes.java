package POOMA_ENTREGAS.PI.ADO.MegaSena;

public class CalculadoraOperacoes {

    public double somar(double num1, double num2) {
        return num1 + num2;
    }

    public double subtrair(double num1, double num2) {
        return num1 - num2;
    }

    public double multiplicar(double num1, double num2) {
        return num1 * num2;
    }

    public double dividir(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
    }

    public double potenciar(double base, double expoente) {
        return Math.pow(base, expoente);
    }
}
