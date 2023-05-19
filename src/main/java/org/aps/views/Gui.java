package org.aps.views;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.aps.views.AddDataTable;

public class Gui {

    Btn btn = new Btn(150, 30, false);
    Lbl lbl = new Lbl(150, 30, 0);
    Table table = new Table(40, false, false);

    void runGUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout(0, 50));
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

        JPanel topPanelFrame = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints(); // gbc sets position, size, etc... within its layout

        gbc.weightx = 1; // adds an extra space on X axis
        gbc.insets = new Insets(10, 50, 10, 50);

        // gbc.ipady = 0;
        // gbc.ipadx = 150;

        gbc.gridx = 0; // object position on X axis grid
        gbc.gridy = 0; //object position on Y axis grid
        topPanelFrame.add(btn.newBtn("CONECTAR"), gbc); // adds a componet with gbc setting 

        gbc.gridx = 1;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("SINCRONIZAR"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("FECHAR"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 100;  // sets the size of the component on X axis
        gbc.ipady = 5;    // sets the size of the component on Y axis
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3; // tells the component to occupy X spaces within grid
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
        AddDataTable t = new AddDataTable();

        JScrollPane scrollTablePane = new JScrollPane(t.addRowToJTable());    

        return scrollTablePane;
        
    }

    public static void main(String[] args) {
        new Gui().runGUI();
    }
}
