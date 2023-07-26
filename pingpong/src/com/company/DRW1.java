package com.company;

import java.awt.*;

public class DRW1 extends Canvas {
    public void paint(Graphics gr) {
        Image im = Toolkit.getDefaultToolkit().getImage("images/author.jpg");
        gr.drawImage(im, 1, 0, 250, 250, this);
        gr.setColor(Color.orange);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 24));
        gr.drawString("Rohachevskyi Dmytro", 300, 35);
        gr.drawString("1BS-20b", 300, 70);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 22));
        gr.drawString("Specialty: Cybersecurity", 270, 105);
        gr.drawString("Instagram: dima_rohachevskyi", 270, 140);
        setBackground(new Color(255, 245, 238));
    }
}