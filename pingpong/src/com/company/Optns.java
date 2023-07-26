package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Optns extends JFrame implements ActionListener {
    JRadioButton light, dark, gray;
    ImageIcon ltimage, dkimage, gyimage;
    Game gm;

    Optns(Game gm0) {
        gm = gm0;
        this.setTitle("Color for field");
        this.setLayout(new FlowLayout());
        ltimage = new ImageIcon("images/white.png");
        dkimage = new ImageIcon("images/black.png");
        gyimage = new ImageIcon("images/gray.png");
        light = new JRadioButton("Light");
        dark = new JRadioButton("Dark");
        gray = new JRadioButton("Gray");
        ButtonGroup group = new ButtonGroup();
        group.add(light);
        group.add(dark);
        group.add(gray);
        light.addActionListener(this);
        light.setIcon(ltimage);
        dark.addActionListener(this);
        dark.setIcon(dkimage);
        gray.addActionListener(this);
        gray.setIcon(gyimage);
        this.add(light);
        this.add(dark);
        this.add(gray);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == light)
            gm.cl = Color.white;
        else if (e.getSource() == dark)
            gm.cl = Color.black;
        else if (e.getSource() == gray)
            gm.cl = Color.gray;
    }
}