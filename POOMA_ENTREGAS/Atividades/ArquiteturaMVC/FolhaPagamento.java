package POOMA_ENTREGAS.Atividades.ArquiteturaMVC;

import java.util.ArrayList;
import java.util.List;

public class FolhaPagamento {
    private List<Funcionario> funcionarios;

    public FolhaPagamento() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void calcularFolha() {
        for (Funcionario funcionario : funcionarios) {
            double pagamento = funcionario.calcularPagamento();
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Departamento: " + funcionario.getDepartamento());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println("Salário: " + pagamento);
            System.out.println("----------");
        }
    }
}
