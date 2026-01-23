package br.com.dio.ui;

import br.com.dio.dao.TarefaDAO;
import br.com.dio.model.Tarefa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class BoardFrame extends JFrame {

    private final TarefaDAO dao = new TarefaDAO();
    private JTable tabelaTarefas;
    private DefaultTableModel tableModel;
    private JTextField inputTarefa;

    public BoardFrame() {
        super("Board Pro - Gerenciador de Tarefas");
        dao.criarTabela();

        configurarJanela();
        inicializarComponentes();
        carregarDados();
    }

    private void configurarJanela() {
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        var panelTopo = new JPanel(new FlowLayout());
        inputTarefa = new JTextField(30);
        var btnAdicionar = new JButton("Nova Tarefa");

        btnAdicionar.addActionListener(e -> adicionarTarefa());

        panelTopo.add(inputTarefa);
        panelTopo.add(btnAdicionar);
        add(panelTopo, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Descrição", "Status"}, 0);
        tabelaTarefas = new JTable(tableModel);
        add(new JScrollPane(tabelaTarefas), BorderLayout.CENTER);

        var panelFim = new JPanel();
        var btnExcluir = new JButton("Concluir/Excluir Selecionada");

        btnExcluir.addActionListener(e -> excluirTarefa());

        panelFim.add(btnExcluir);
        add(panelFim, BorderLayout.SOUTH);
    }

    private void adicionarTarefa() {
        try {
            if (!inputTarefa.getText().isEmpty()) {
                dao.salvar(inputTarefa.getText());
                inputTarefa.setText("");
                carregarDados();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void excluirTarefa() {
        int linha = tabelaTarefas.getSelectedRow();
        if (linha >= 0) {
            int id = (int) tableModel.getValueAt(linha, 0);
            try {
                dao.excluir(id);
                carregarDados();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa na tabela.");
        }
    }

    private void carregarDados() {
        try {
            tableModel.setRowCount(0);
            for (Tarefa t : dao.listar()) {
                tableModel.addRow(new Object[]{t.getId(), t.getNome(), t.getStatus()});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}