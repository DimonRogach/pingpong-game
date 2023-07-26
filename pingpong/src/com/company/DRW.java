package com.company;

import java.awt.*;

public class DRW extends Canvas {
    public void paint(Graphics gr) {
        Image im = Toolkit.getDefaultToolkit().getImage("images/background.jpg");
        gr.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}