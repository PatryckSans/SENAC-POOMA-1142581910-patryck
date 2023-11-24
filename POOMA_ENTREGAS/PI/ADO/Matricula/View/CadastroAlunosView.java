package POOMA_ENTREGAS.PI.ADO.Matricula.View;

import javax.swing.*;

import POOMA_ENTREGAS.PI.ADO.Matricula.Controller.CadastroAlunosController;

import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroAlunosView {

    private JFrame frame;
    private JTextField fieldMatricula;
    private JTextField fieldNome;
    private DefaultListModel<String> listModel;

    public CadastroAlunosView() {
        frame = new JFrame("Cadastro de Alunos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());

        JPanel panelDados = new JPanel(new GridLayout(3, 2));
        JLabel labelMatricula = new JLabel("Matricula: ");
        fieldMatricula = new JTextField();
        JLabel labelNome = new JLabel("Nome: ");
        fieldNome = new JTextField();
        JButton buttonGravar = new JButton("Gravar Registro");

        listModel = new DefaultListModel<>();
        JList<String> matriculasList = new JList<>(listModel);

        buttonGravar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroAlunosController.gravarRegistro(fieldMatricula.getText(), fieldNome.getText());
            }
        });

        panelDados.add(labelMatricula);
        panelDados.add(fieldMatricula);
        panelDados.add(labelNome);
        panelDados.add(fieldNome);
        panelDados.add(buttonGravar);

        container.add(panelDados, BorderLayout.WEST);
        container.add(new JScrollPane(matriculasList), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public void atualizarLista(List<String> matriculas) {
        listModel.clear();
        for (String matricula : matriculas) {
            listModel.addElement(matricula);
        }
    }
}
