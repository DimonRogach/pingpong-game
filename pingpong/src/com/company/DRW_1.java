package com.company;

import java.awt.*;

public class DRW_1 extends Canvas {
    Image im1, im2, im3, im4, im5, im6;

    public void paint(Graphics gr) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        im1 = tk.getImage("images/W_button.png");
        im2 = tk.getImage("images/S_button.png");
        im3 = tk.getImage("images/U_button.png");
        im4 = tk.getImage("images/D_button.png");
        im5 = tk.getImage("images/Smile.png");
        im6 = tk.getImage("images/E_button.png");
        gr.drawImage(im1, 10, 230, 40, 40, this);
        gr.drawImage(im2, 300, 230, 40, 40, this);
        gr.drawImage(im3, 10, 300, 40, 40, this);
        gr.drawImage(im4, 300, 300, 40, 40, this);
        gr.drawImage(im5, 550, 350, 100, 100, this);
        gr.drawImage(im6, 10, 375, 40, 40, this);
        gr.setColor(Color.gray);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 16));
        gr.drawString("Instructions for the game Ping Pong", 250, 35);
        gr.setColor(Color.ORANGE);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD + Font.TYPE1_FONT, 14));
        gr.drawString("Greetings, dear players, before starting the game, familiarize yourself with the rules of the game", 10,
                70);
        gr.drawString("The game is designed for two players." + "When starting the game, you can register by clicking on",
                10, 105);
        gr.drawString("corresponding 'Registration' button. If you do not want to fill out the registration, then you will play in",
                10, 140);
        gr.drawString("in guest mode (Player1 and Player2 respectively). ", 10, 175);
        gr.drawString(" Rackets are controlled using", 325, 175);
        gr.drawString("corresponding keyboard keys." + "You can familiarize yourself with the corresponding controls below:",
                10, 200);
        gr.setColor(Color.pink);
        gr.setFont(new Font("Arial", Font.BOLD, 16));
        gr.drawString("Left racket:", 10, 220);
        gr.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
        gr.setColor(Color.black);
        gr.drawString(" - the racket moves up;", 50, 253);
        gr.drawString(" - the racket moves down;", 350, 253);
        gr.setColor(Color.pink);
        gr.setFont(new Font("Arial", Font.BOLD, 16));
        gr.drawString("Right racket:", 10, 290);
        gr.setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 16));
        gr.setColor(Color.black);
        gr.drawString(" - the racket moves up;", 50, 326);
        gr.drawString(" - the racket moves down;", 350, 326);
        gr.setColor(Color.pink);
        gr.setFont(new Font("Arial", Font.BOLD, 16));
        gr.drawString("Exit the program:", 10, 360);
        gr.setColor(Color.black);
        gr.drawString(" - program completion.", 50, 398);
        gr.setColor(Color.ORANGE);
        gr.setFont(new Font("Arial", Font.ITALIC + Font.BOLD, 24));
        gr.drawString("I wish you to have fun in our game.", 10, 450);
    }

    public boolean imageUpdate(Image im1, int flags, int x, int y, int w, int h) {
        boolean fAllLoaded = ((flags & ALLBITS) != 0);
        if (fAllLoaded) repaint();
        return (!fAllLoaded);
    }
}