package POOMA_ENTREGAS.ImplementacaoPI.ParteTeste;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public String lerString(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public double lerDouble(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextDouble();
    }

    public int lerInt(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextInt();
    }
}
