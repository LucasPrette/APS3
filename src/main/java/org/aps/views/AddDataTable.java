package org.aps.views;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.List;

import org.aps.implementations.EndangeredSpecies;

public class AddDataTable {
    // ArrayList<EndangeredSpecie> endangeredSpecies;
    
    public JTable addRowToJTable() {



        ArrayList<String> columns = new ArrayList<String>();
        ArrayList<String[]> values = new ArrayList<String[]>();

        columns.add("col1");
        columns.add("col2");
        columns.add("col3");

        for (int i = 0; i < 100; i++) {
            values.add(new String[] {"val"+i,"val"+i,"val"+i});
        }

        TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][] {}), columns.toArray());
        JTable table = new JTable(tableModel);

        // Table tbe = new Table(35, false, false);
        // JTable table = tbe.create();

        // DefaultTableModel model = (DefaultTableModel) table.getModel();
        // table.setModel(model);

        // Object rowData[] = new Object[9];
        
        // for(int i = 0; i < test.size(); i++) {
        //     rowData[0] = test.get(i).getType();
        //     rowData[1] = test.get(i).getGroup();
        //     rowData[2] = test.get(i).getFamily();
        //     rowData[3] = test.get(i).getSpecies();
        //     rowData[4] = test.get(i).getName();
        //     rowData[5] = test.get(i).getThreatCategories();
        //     rowData[6] = test.get(i).getBiomes();
        //     rowData[7] = test.get(i).getMainThreats();
        //     rowData[8] = test.get(i).getOccurrenceStates();

        //     model.addRow(rowData);
        //     model.addColumn(model, rowData);
        // }

        return table;
    }

}