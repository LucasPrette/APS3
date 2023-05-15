package org.aps.views;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Gui {
    void runGUI() {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(5,1));
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        topPanel(frame);
        searchPanel(frame);
        frame.setVisible(true);
    }

    // top panel is added at NORTH within frame
    void topPanel(JFrame frame) {
        JPanel topPanelFrame = new JPanel(new BorderLayout(0, 0));
        topPanelFrame.setBackground(Color.black);
        // topPanelFrame.setPreferredSize(new Dimension(100, 100));

        JPanel centerPanel = new JPanel(new FlowLayout(1, 40, 40));
        centerPanel.setPreferredSize(new Dimension(100, 100));

        JButton conectBtn = new JButton("CONECTAR");
        JButton syncBtn = new JButton("SINCRONIZAR DADOS");
        conectBtn.setFocusable(false);
        syncBtn.setFocusable(false);

        JPanel sidePanel = new JPanel(new FlowLayout(1, 10, 40));
        JButton closeBtn = new JButton("FECHAR");
        closeBtn.setFocusable(false);

        centerPanel.add(conectBtn);
        centerPanel.add(syncBtn);

        sidePanel.add(closeBtn);

        topPanelFrame.add(BorderLayout.CENTER, centerPanel);
        topPanelFrame.add(BorderLayout.EAST, sidePanel);
        frame.add(BorderLayout.NORTH, topPanelFrame);
    }

    void searchPanel(JFrame frame) {
        Container ffContainer = new Container();
        ffContainer.setLayout(new GridLayout(2,1));
        ffContainer.setPreferredSize(new Dimension(100, 50));
        JLabel ff = new JLabel("Fauna/Flora");
        JComboBox ffOption = new JComboBox<>();
        ffOption.addItem("Fauna");
        ffOption.addItem("Flora");
        ffContainer.add(ff);
        ffContainer.add(ffOption);

        Container groupContainer = new Container();
        groupContainer.setLayout(new GridLayout(2,1));
        groupContainer.setPreferredSize(new Dimension(100, 50));
        JLabel groupLabel = new JLabel("Grupo");
        JComboBox groupComboBox = new JComboBox<>();
        groupContainer.add(groupLabel);
        groupContainer.add(groupComboBox);

        Container fmlContainer = new Container();
        fmlContainer.setLayout(new GridLayout(2,1));
        fmlContainer.setPreferredSize(new Dimension(175, 50));
        JLabel fmlLabel = new JLabel("Familia");
        JComboBox fmlComboBox = new JComboBox<>();
        fmlContainer.add(fmlLabel);
        fmlContainer.add(fmlComboBox);

        Container especiesContainer = new Container();
        especiesContainer.setLayout(new GridLayout(2,1));
        especiesContainer.setPreferredSize(new Dimension(175, 50));
        JLabel especiesLabel = new JLabel("Espécie");
        JTextArea especiesTextArea = new JTextArea();
        especiesContainer.add(especiesLabel);
        especiesContainer.add(especiesTextArea);

        Container biomeContainer = new Container();
        biomeContainer.setLayout(new GridLayout(2,1));
        biomeContainer.setPreferredSize(new Dimension(175, 50));
        JLabel biomeLabel = new JLabel("BIOMA");
        JTextArea biomeTextArea = new JTextArea();
        biomeContainer.add(biomeLabel);
        biomeContainer.add(biomeTextArea);

        Container threatCatContainer = new Container();
        threatCatContainer.setLayout(new GridLayout(2,1));
        threatCatContainer.setPreferredSize(new Dimension(175, 50));
        JLabel threatCatLabel = new JLabel("CATEGORIA DE AMEAÇA");
        JTextArea threatCatTextArea = new JTextArea();
        threatCatContainer.add(threatCatLabel);
        threatCatContainer.add(threatCatTextArea);

        Container mainThreatsContainer = new Container();
        mainThreatsContainer.setLayout(new GridLayout(2,1));
        mainThreatsContainer.setPreferredSize(new Dimension(175, 50));
        JLabel mainThreatsLabel = new JLabel("PRINCIPAIS AMEAÇAS");
        JTextArea mainThreatsTextArea = new JTextArea();
        mainThreatsContainer.add(mainThreatsLabel);
        mainThreatsContainer.add(mainThreatsTextArea);

        Container commomNameContainer = new Container();
        commomNameContainer.setLayout(new GridLayout(2,1));
        commomNameContainer.setPreferredSize(new Dimension(175, 50));
        JLabel commomNameLabel = new JLabel("NOME COMUM");
        JTextArea commomNameTextArea = new JTextArea();
        commomNameContainer.add(commomNameLabel);
        commomNameContainer.add(commomNameTextArea);

        Container estatesOcurrenciesContainer = new Container();
        estatesOcurrenciesContainer.setLayout(new GridLayout(2,1));
        estatesOcurrenciesContainer.setPreferredSize(new Dimension(175, 50));
        JLabel estatesOcurrenciesLabel = new JLabel("ESTADOS DE OCORRÊNCIA");
        JTextArea estatesOcurrenciesTextArea = new JTextArea();
        estatesOcurrenciesContainer.add(estatesOcurrenciesLabel);
        estatesOcurrenciesContainer.add(estatesOcurrenciesTextArea);


        Container btnContainer = new Container();
        btnContainer.setLayout(new GridLayout(2, 1));
        btnContainer.setPreferredSize(new Dimension(175, 0));
        JButton searchBtn = new JButton("PESQUISAR");
        searchBtn.setFocusable(false);
        searchBtn.setPreferredSize(new Dimension(5, 30));
        JButton clearBtn = new JButton("LIMPAR");
        clearBtn.setPreferredSize(new Dimension(5, 30));
        clearBtn.setFocusable(false);
        btnContainer.add(searchBtn);
        btnContainer.add(clearBtn);
        
        
        JPanel midPanel = new JPanel();
        midPanel.setLayout(new FlowLayout(0, 40, 10));
        midPanel.add(ffContainer);
        midPanel.add(groupContainer);
        midPanel.add(fmlContainer);
        midPanel.add(especiesContainer);
        midPanel.add(biomeContainer);
        midPanel.add(threatCatContainer);
        midPanel.add(mainThreatsContainer);
        midPanel.add(commomNameContainer);
        midPanel.add(estatesOcurrenciesContainer);
        
        
        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder(" [ OPÇÕES PESQUISA ] "));
        searchPanel.setLayout(new BorderLayout(350, 10));
        searchPanel.add(BorderLayout.CENTER, midPanel);
        searchPanel.add(BorderLayout.EAST, btnContainer);

        frame.add(searchPanel);
    }

    void tablePanel(JFrame frame) {
        // implement table 
    }

    public static void main(String[] args) {
        new Gui().runGUI();
    }
}
