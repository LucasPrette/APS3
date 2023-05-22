package org.aps.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import org.aps.implementations.EndangeredSpecies;
import org.aps.implementations.Type;
import org.aps.repositories.*;
import org.aps.services.CsvConverterService;
import org.aps.implementations.*;

public class Gui {
    Btn btn = new Btn(165, 30, false);
    Lbl lbl = new Lbl(20, 30, 0);
    ComboBox cb = new ComboBox(0, 0, null, null);
    TextField textField = new TextField();
    DefaultTableModel dtm;
    JTable normalTable;
    JFrame frame = new JFrame();
    JScrollPane scrollTablePane;

    public void runGUI() {
        frame.setLayout(new BorderLayout(0, 50));
        
        frame.setSize(900, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(BorderLayout.NORTH, topPanel());
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
        gbc.insets = new Insets(10, 50, 10, 9);

        // gbc.ipady = 0;
        // gbc.ipadx = 150;

        gbc.gridx = 0; // object position on X axis grid
        gbc.gridy = 0; //object position on Y axis grid

        topPanelFrame.add(btn.newBtn("CONECTAR", new ActionListener() {
            public void actionPerformed (ActionEvent e ) {
                AddDataTable dataTable = new AddDataTable();
                EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

                List<EndangeredSpecies> endangeredSpecies = endangeredSpeciesRepository.findAll();
                System.out.println(endangeredSpecies.size());
                dtm = dataTable.addRowToJTable(endangeredSpecies);
                normalTable.setModel(dtm);
                normalTable.setVisible(true);
            }
        }), gbc); // adds a component within gbc setting

        gbc.gridx = 1;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("SINCRONIZAR DADOS", new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                long startTime = System.nanoTime();
                System.out.print("STARTED AT: " + startTime + '\n');

                CsvConverterService csvConverterService = new CsvConverterService();
                EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

                List<EndangeredSpecies> endangeredSpecies = csvConverterService.csvToJClass();

                endangeredSpeciesRepository.populate(endangeredSpecies);

                long endTime = System.nanoTime();
                System.out.print("FINISHED AT: " + endTime + '\n');
                System.out.print("DIFF: " + (endTime - startTime));
            }
        }), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        topPanelFrame.add(btn.newBtn("FECHAR", new ActionListener() {
            public void actionPerformed (ActionEvent e ) {
                System.exit(0);
            }
        }), gbc);

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
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.ipadx = 100;
        gbc.ipady = 5;
        gbc.insets = new Insets(0, 10, 5, 0);

        // adding components
        gbc.gridx = 0;
        gbc.gridy = 0;
        searchPanel.add(lbl.create("Fauna/Flora"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        ArrayList<Type> typesList = new TypesRepository().findAll();
        JComboBox<String> cbType = cb.createType(typesList);
        searchPanel.add(cbType, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        searchPanel.add(lbl.create("Grupo"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        ArrayList<Group> groupsList = new GroupiesRepository().findAll();
        JComboBox<String> cbGroups = cb.createGroup(groupsList);
        searchPanel.add(cbGroups, gbc);


        gbc.gridx = 2;
        gbc.gridy = 0;
        searchPanel.add(lbl.create("Familia"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        JTextField familyTxt = new JTextField();
        // add Toretto here
        searchPanel.add(familyTxt, gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        searchPanel.add(lbl.create("Especie"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        JTextField specieTxt = new JTextField();
        searchPanel.add(specieTxt, gbc);


        gbc.gridx = 4;
        gbc.gridy = 0;
        searchPanel.add(lbl.create("Bioma"), gbc);

        gbc.gridx = 4;
        gbc.gridy = 1;
        ArrayList<Biome> biomesList = new BiomesRepository().findAll();
        JComboBox<String> cbBiome = cb.createBiomes(biomesList);
        searchPanel.add(cbBiome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        searchPanel.add(lbl.create("Categoria ameaca"), gbc);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.gridy = 3;
        ArrayList<ThreatCategory> threatList = new ThreatCategoriesRepository().findAll();
        JComboBox<String> cbThreats = cb.createThreatCategories(threatList);
        searchPanel.add(cbThreats, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 2;
        gbc.gridy = 2;
        searchPanel.add(lbl.create("Principais ameacas"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 3;
        JTextField mainThreatTxt = new JTextField();
        searchPanel.add(mainThreatTxt, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        searchPanel.add(lbl.create("Nome Comum"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        JTextField nameTxt = new JTextField();
        searchPanel.add(nameTxt, gbc);

        gbc.gridx = 4;
        gbc.gridy = 2;
        searchPanel.add(lbl.create("Estado de ocorrencia"), gbc);

        gbc.gridx = 4;
        gbc.gridy = 3;
        ArrayList<State> statesList = new StatesRepository().findAll();
        JComboBox<String> cbStates = cb.createStates(statesList);
        searchPanel.add(cbStates, gbc);


        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridheight = 2;

        tableFrame();
        searchPanel.add(btn.newBtn("PESQUISAR", new ActionListener() {
            public void actionPerformed (ActionEvent e) {
                Biome elementBiome = null;
                for(Biome element : biomesList) {
                    if(element.getName() == cbType.getSelectedItem()) {
                        elementBiome = element;
                    }
                }

                State elementState = null;
                for(State element : statesList) {
                    if(element.getName() == cbStates.getSelectedItem()){
                        elementState = element;
                    }
                }

                Type elementType = null;
                for(Type element : typesList) {
                    if(element.getName() == cbType.getSelectedItem()) {
                        elementType = element;
                    }
                }

                ThreatCategory elementThreatCategory = null;
                for(ThreatCategory element : threatList) {
                    if(element.getName() == cbThreats.getSelectedItem()) {
                        elementThreatCategory = element;
                    }
                }

                Group elementGroup = null;
                for(Group element : groupsList) {
                    if(element.getName() == cbGroups.getSelectedItem()) {
                        elementGroup = element;
                    }
                }

                Map<String, Object> filters = new HashMap<String, Object>();
                ArrayList<String> selectedFilter = new ArrayList<String>();

                filters.put("type", elementType.getRef());
                filters.put("group", elementGroup.getRef());
                filters.put("species", specieTxt.getText());
                filters.put("biome", elementBiome.getRef());
                filters.put("threatCategory", elementThreatCategory.getRef());
                filters.put("mainThreats", mainThreatTxt.getText());
                filters.put("name", nameTxt.getText());
                filters.put("occurrenceState", elementState.getRef());

                for (Map.Entry<String, Object> filter : filters.entrySet()) {
                    String filterValue = filter.getValue().toString();

                    if (filterValue.length() == 0) {
                        continue;
                    }

                    selectedFilter.add(filter.getKey());
                    selectedFilter.add(filterValue);
                    break;
                }

                if (selectedFilter.size() == 0) {
                    return;
                }

                ArrayList<EndangeredSpecies> endangeredSpecies = new ArrayList<EndangeredSpecies>();
                EndangeredSpeciesRepository endangeredSpeciesRepository = new EndangeredSpeciesRepository();

                // index 0 is the name of filter and the index 1 is the value of filter
                switch (selectedFilter.get(0)) {
                    case "type":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByType(selectedFilter.get(1));
                        break;
                    case "group":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByGroup(selectedFilter.get(1));
                        break;
                    case "species":
                        endangeredSpecies = endangeredSpeciesRepository.findAllBySpecie(selectedFilter.get(1));
                        break;
                    case "biome":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByBiome(selectedFilter.get(1));
                        break;
                    case "threatCategory":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByThreatCategory(selectedFilter.get(1));
                        break;
                    case "mainThreats":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByMainThreats(selectedFilter.get(1));
                        break;
                    case "name":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByName(selectedFilter.get(1));
                        break;
                    case "occurrenceState":
                        endangeredSpecies = endangeredSpeciesRepository.findAllByOccurrenceStates(selectedFilter.get(1));
                        break;
                    default:
                        System.out.println("key not mapped");
                        break;
                }

                AddDataTable dataTable = new AddDataTable();

                dtm = dataTable.addRowToJTable(endangeredSpecies);
                normalTable.setModel(dtm);
                normalTable.setVisible(true);
            }
        }), gbc);


        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridheight = 2;

        searchPanel.add(btn.newBtn("LIMPAR", new ActionListener() {
            public void actionPerformed (ActionEvent e ) {
                while (dtm.getRowCount() > 0) {
                    dtm.removeRow(0);
                    normalTable.setModel(dtm);
                    normalTable.repaint();
                }
            }
        }), gbc);

        return searchPanel;
    }

    void tableFrame() {
        normalTable = new JTable();
        scrollTablePane = new JScrollPane(normalTable);
        frame.add(scrollTablePane);
    }
}
