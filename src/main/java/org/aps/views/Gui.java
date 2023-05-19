package org.aps.views;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Gui {

    Btn btn = new Btn(150, 30, false);
    Lbl lbl = new Lbl(150, 30, 0);

    void runGUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(0, 50));
        System.out.println(frame.getMaximumSize());
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(BorderLayout.NORTH, topPanel());
        frame.add(BorderLayout.CENTER, tableFrame());
        frame.add(BorderLayout.EAST, new JPanel());
        frame.add(BorderLayout.WEST, new JPanel());
        frame.setVisible(true);
    }

    // top panel is added at NORTH within frame
    JPanel topPanel() {
        // top panel adds the main btns: Connect, Sync and Close

        // instance of main frame
        JPanel topPanelFrame = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weightx = 1;
        gbc.insets = new Insets(10, 50, 10, 50);

        // gbc.ipady = 0;
        // gbc.ipadx = 150;

        gbc.gridx = 0;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("CONECTAR"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("SINCRONIZAR"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("FECHAR"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 100;
        gbc.ipady = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        topPanelFrame.add(searchPanel(), gbc);

        return topPanelFrame;
    }

    JPanel searchPanel() {

        JPanel searchPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        searchPanel.setBorder(BorderFactory.createTitledBorder("Opções de Pesquisa"));

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 100;
        gbc.ipady = 5;
        gbc.insets = new Insets(0, 10, 5, 0);

        // adding components
        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Fauna/Flora", null, 0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        searchPanel.add(new JComboBox<String>(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Familia", null, 0), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        searchPanel.add(new JComboBox<>(), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Especie", null, 0), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        searchPanel.add(new TextField(), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        searchPanel.add(new JLabel("Bioma", null, 0), gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        searchPanel.add(new JTextField(), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchPanel.add(new JLabel("Categoria ameaca", null, 0), gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        searchPanel.add(new JTextField(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        searchPanel.add(new JLabel("Principais ameacas", null, 0), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        searchPanel.add(new JTextField(), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        searchPanel.add(new JLabel("Nome Comum", null, 0), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        searchPanel.add(new JTextField(), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        searchPanel.add(new JLabel("Estado de ocorrencia", null, 0), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        searchPanel.add(new JTextField(), gbc);

        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        searchPanel.add(new JButton("PESQUISAR", null), gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.gridheight = 2;
        searchPanel.add(new JButton("LIMPAR", null), gbc);

        return searchPanel;
    }

    JScrollPane tableFrame() {

        // implement table

        JPanel tablePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        tablePanel.setPreferredSize(new Dimension(500, 500));

        String[] columnNames = { "Fauna/Flora", "Grupo", "Familia", "Especie(Simplificado)", "Nome Comum",
                "Categoria de Ameaça", "Bioma", "Principais Ameaças", "Estados de Ocorrência" };

        Object[][] data = {
                { "Flora", "angiospermas", "salicacae", "abatia angeliana", "-", "Vulneravel(VU)", "Mata Atlantica",
                        "perda de habitat/ degradacao(induzida por humanos)", "pr"
                },
                { "Flora", "angiospermas", "salicacae", "abatia angeliana", "-", "Vulneravel(VU)", "Mata Atlantica",
                        "perda de habitat/ degradacao(induzida por humanos)", "pr"
                },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null, null }

        };

        JTable table = new JTable(data, columnNames);
        table.setRowHeight(32);
        table.setAutoResizeMode(5);
        table.setEnabled(false);
        table.setDragEnabled(false);
        table.setFocusable(false);

        JScrollPane scrollTablePane = new JScrollPane(table);

        return scrollTablePane;

    }

    public static void main(String[] args) {
        new Gui().runGUI();
    }
}
