package POOMA_ENTREGAS.ImplementacaoPI.Parte2;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ControladorAbastecimento controladorAbastecimento = new ControladorAbastecimento(interfaceUsuario);

        controladorAbastecimento.registrarAbastecimento();
    }
}
