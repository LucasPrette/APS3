package org.aps.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Btn extends JButton{

    private int width;
    private int height;
    private Boolean focusable;


    public Btn
    (
        int width,
        int height,
        Boolean focusable
    ) 
    {
        this.width = width;
        this.height = height;
        this.focusable = focusable;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Boolean getFocusable() {
        return focusable;
    }


    public JButton newBtn(String txt, ActionListener listener) {
        JButton btn = new JButton(txt);
        btn.setPreferredSize(new Dimension(getWidth(), getHeight()));
        btn.setFocusable(getFocusable());

        btn.addActionListener(listener);
        
        return btn;
    }

}
