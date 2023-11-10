package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

public class FolhaPagamentoController {
    private FolhaPagamento folhaPagamento;
    private FolhaPagamentoView view;

    public FolhaPagamentoController() {
        this.folhaPagamento = new FolhaPagamento();
        this.view = new FolhaPagamentoView();
    }

    public void executar() {
        boolean continuar = true;

        while (continuar) {
            Funcionario funcionario = view.lerFuncionario();
            if (funcionario != null) {
                folhaPagamento.adicionarFuncionario(funcionario);
            }

            System.out.print("Deseja adicionar outro funcionário? (S/N): ");
            String resposta = view.getScanner().nextLine().toUpperCase();

            if (!resposta.equals("S")) {
                continuar = false;
            }
        }

        folhaPagamento.calcularFolha();
    }
}
