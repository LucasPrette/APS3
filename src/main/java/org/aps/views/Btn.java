package org.aps.views;

import java.awt.*;
import javax.swing.JButton;

public class Btn {

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


    public JButton newBtn(String txt) {
        JButton btn = new JButton(txt);
        btn.setPreferredSize(new Dimension(getWidth(), getHeight()));
        btn.setFocusable(getFocusable());
        
        return btn;
    }

}
