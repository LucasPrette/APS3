package org.aps.views;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class ComboBox {
    private ArrayList<String> itens;
    private int width;
    private int height;
    private String identifier = "Int";
    private Boolean editable;

    public ComboBox
    (
        ArrayList<String> itens,
        int width,
        int height,
        String identifier,
        Boolean editable
    )
    {
        this.itens = itens;
        this.width = width;
        this.height = height;
        this.identifier = identifier;
        this.editable = editable;

    }

    public int getHeight() {
        return height;
    }

    public String getIdentifier() {
        return identifier;
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

    public JComboBox create() {
        JComboBox<String> comboBox  = new JComboBox<String>();
        for(int i = 0; i < getItens().size(); i++) {
            comboBox.addItem(getItens().get(i));
        }
        comboBox.setEditable(getEditable());

        return comboBox;
    }


}
