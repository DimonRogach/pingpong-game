package com.company;
import javax.swing.*;
public class WinMain {
    public WinMain(String title,Game game) {
        JFrame frame = new JFrame(title);
        frame.setResizable(false);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
