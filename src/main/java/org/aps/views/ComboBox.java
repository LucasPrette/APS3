package org.aps.views;


import java.util.ArrayList;

import javax.swing.JComboBox;

import com.google.cloud.Identity.Type;

public class ComboBox {
    private ArrayList<String> itens;
    private int width;
    private int height;
    private Boolean editable;

    public ComboBox
    (
        int width,
        int height,
        String identifier,
        Boolean editable
    )
    {
        this.width = width;
        this.height = height;
        this.editable = editable;

    }

    public int getHeight() {
        return height;
    }

    public ArrayList<String> getItens() {
        return itens;
    }

    public int getWidth() {
        return width;
    }

    public Boolean getEditable() {
        return editable;
    }

    public JComboBox create(ArrayList list) {
        JComboBox<String> comboBox  = new JComboBox<String>();
        for(int i = 0; i < list.size(); i++) {
            comboBox.addItem(list.get(i).getClass().getName());
        }
        comboBox.setEditable(getEditable());

        return comboBox;
    }


}
