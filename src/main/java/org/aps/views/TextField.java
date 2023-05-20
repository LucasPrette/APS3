package org.aps.views;

import javax.swing.JTextField;

public class TextField {
    private String text;

    public TextField () {}

    public TextField 
    (
        String text
    )
    {
        this.text = text;
    }


    public JTextField create() {
        JTextField textField = new JTextField();

        

        return textField;

    }
}
