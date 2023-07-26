package com.company;

import java.awt.*;

public class DRW2 extends Canvas {
    public void paint(Graphics gr) {
        Image im = Toolkit.getDefaultToolkit().getImage("images/tsk.png");
        gr.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
        gr.setColor(Color.BLACK);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 24));
        gr.drawString("Implement a Ping-Pong game", 150, 35);
        gr.setColor(new Color(255, 160, 122));
        gr.drawString("Develop a software tool, the game «Ping Pong», which", 10, 80);
        gr.drawString("will contain a menu with the following items, as game", 10, 115);
        gr.drawString("rules, task information, information about the author.", 10, 150);
        gr.drawString("There must be work with files, using collections", 10, 185);
        gr.drawString("and streams, internal classes, etc.", 10, 215);
    }
}