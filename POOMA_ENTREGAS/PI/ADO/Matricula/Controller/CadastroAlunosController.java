package POOMA_ENTREGAS.PI.ADO.Matricula.Controller;

import javax.swing.*;

import POOMA_ENTREGAS.PI.ADO.Matricula.Model.Aluno;
import POOMA_ENTREGAS.PI.ADO.Matricula.View.CadastroAlunosView;

import java.util.ArrayList;
import java.util.List;

public class CadastroAlunosController {

    private static List<String> matriculasCadastradas = new ArrayList<>();
    private static CadastroAlunosView view;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            view = new CadastroAlunosView();
        });
    }

    public static void gravarRegistro(String matricula, String nome) {
        if (!matricula.isEmpty() && !nome.isEmpty()) {
            Aluno aluno = new Aluno(matricula, nome);
            matriculasCadastradas.add(aluno.getMatricula() + "      " + aluno.getNome());

            view.atualizarLista(matriculasCadastradas);

            System.out.println("Cadastro realizado com sucesso: " + aluno);
        } else {
            System.out.println("Preencha todos os campos");
        }
    }
}
