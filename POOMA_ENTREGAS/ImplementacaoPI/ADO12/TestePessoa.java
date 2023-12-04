import javax.swing.JOptionPane;

public class TestePessoa {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

        do {
            String logradouro = JOptionPane.showInputDialog("Digite o logradouro:");
            int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número:"));
            String complemento = JOptionPane.showInputDialog("Digite o complemento:");

            Endereco endereco = new Endereco();
            endereco.setLogradouro(logradouro);
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);

            pessoa.getEnderecos().add(endereco);

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja informar mais endereços?");
            if (resposta != 0) {
                break;
            }
        } while (true);

        pessoa.imprimirEnderecos1();
        pessoa.imprimirEnderecos2();
    }
}
