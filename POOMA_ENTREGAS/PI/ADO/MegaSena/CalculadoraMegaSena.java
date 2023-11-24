package POOMA_ENTREGAS.PI.ADO.MegaSena;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraMegaSena extends Application {

    private Label labelResultado;
    private TextField textFieldNumero1;
    private TextField textFieldNumero2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button buttonSoma = new Button("Soma");
        Button buttonMultiplicacao = new Button("Multiplicação");
        Button buttonPotenciacao = new Button("Potenciação");
        Button buttonSubtracao = new Button("Subtração");
        Button buttonDivisao = new Button("Divisão");
        Button buttonMegaSena = new Button("Mega Sena");
        Button buttonCalcular = new Button("Calcular");
        Button buttonSair = new Button("Sair");

        textFieldNumero1 = new TextField();
        textFieldNumero2 = new TextField();

        labelResultado = new Label();

        CalculadoraOperacoes calculadora = new CalculadoraOperacoes();

        buttonSoma.setOnAction(event -> calcularResultado(calculadora::somar));
        buttonMultiplicacao.setOnAction(event -> calcularResultado(calculadora::multiplicar));
        buttonPotenciacao.setOnAction(event -> calcularResultado(calculadora::potenciar));
        buttonSubtracao.setOnAction(event -> calcularResultado(calculadora::subtrair));
        buttonDivisao.setOnAction(event -> calcularResultado(calculadora::dividir));

        buttonMegaSena.setOnAction(event -> {
            MegaSenaGenerator megaSenaGenerator = new MegaSenaGenerator();
            int[] numerosSorteados = megaSenaGenerator.sortearNumeros();
            labelResultado.setText("Números sorteados: " + arrayToString(numerosSorteados));
        });

        buttonCalcular.setOnAction(event -> labelResultado.setText("Escolha uma operação"));

        buttonSair.setOnAction(event -> System.exit(0));

        VBox vBox = new VBox(buttonSoma, buttonMultiplicacao, buttonPotenciacao, buttonSubtracao, buttonDivisao,
                buttonMegaSena, textFieldNumero1, textFieldNumero2, buttonCalcular, labelResultado, buttonSair);

        Scene scene = new Scene(vBox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Calculadora Mega Sena");
        primaryStage.show();
    }

    private void calcularResultado(BinaryOperation operation) {
        try {
            double num1 = Double.parseDouble(textFieldNumero1.getText());
            double num2 = Double.parseDouble(textFieldNumero2.getText());
            double resultado = operation.apply(num1, num2);
            labelResultado.setText(String.valueOf(resultado));
        } catch (NumberFormatException e) {
            labelResultado.setText("Digite números válidos");
        } catch (IllegalArgumentException e) {
            labelResultado.setText(e.getMessage());
        }
    }

    private String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int num : array) {
            result.append(num).append(" ");
        }
        return result.toString().trim();
    }

    interface BinaryOperation {
        double apply(double num1, double num2);
    }
}
