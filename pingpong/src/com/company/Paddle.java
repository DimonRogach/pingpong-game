package com.company;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.ArrayList;

public class Paddle {
    private int x, y;
    private int vel = 0;
    private int speed = 10;
    private int width = 22, height = 85;
    private int score = 0;
    private Color color;
    private boolean left;

    private boolean gameWon = false;

    String player1, player2;
    Game gm;

    public Paddle(Game g0, Color c, boolean left) throws IOException {
        gm = g0;
        color = c;
        this.left = left;
        if (left)
            x = 0;
        else
            x = Game.WIDTH - width;
        y = Game.HEIGHT / 2 - height / 2;
    }

    public void addPoint() {
        score++;
    }

    public void point1() {
        gameWon = true;
        if (score == 7) {
            JOptionPane.showMessageDialog(null, "Congratulations " + player1 + ", you scored 7 points and won", "WIN",
                    JOptionPane.INFORMATION_MESSAGE);
            gm.gameThread.interrupt();
            closeWindow();
        }
    }

    public void point2() {
        gameWon = true;
        if (score == 7)
            JOptionPane.showMessageDialog(null, "Congratulations " + player2 + ", you scored 7 points and won", "WIN",
                    JOptionPane.INFORMATION_MESSAGE);
        gm.gameThread.interrupt();
        closeWindow();

    }

    public void draw(Graphics g) throws IOException {

        g.setColor(color);
        g.fillRect(x, y, width, height);

        int sx;
        int padding = 25;
        g.setColor(Color.pink);
        String scoreText = Integer.toString(score);
        Font font = new Font("Roboto", Font.PLAIN, 50);
        if (left) {
            int strWidth = g.getFontMetrics(font).stringWidth(scoreText);
            sx = Game.WIDTH / 2 - padding - strWidth;
        } else {
            sx = Game.WIDTH / 2 + padding;
        }
        g.setFont(font);
        g.drawString(scoreText, sx, 50);
        ArrayList<String> aList = new ArrayList<>();
        FileInputStream in = new FileInputStream("users.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String tmp = "";
        while ((tmp = br.readLine()) != null) {
            aList.add(tmp);
        }
        br.close();

        for (int i = aList.size() - 1; i < aList.size(); i++) {
            player1 = aList.get(i).toString();
        }
        for (int i = aList.size() - 2; i >= aList.size() - 2; i--) {
            player2 = aList.get(i).toString();
        }
        g.drawString(player2, 50, 50);
        g.drawString(player1, 750, 50);
    }

    public void update(Ball b) {

        y = Game.ensureRange(y + vel, 0, Game.HEIGHT - height);

        int ballX = b.getX();
        int ballY = b.getY();
        if (left) {
            if (ballX <= width + x && ballY + Ball.SIZE >= y && ballY <= y + height)
                b.changeXDir();
        } else {
            if (ballX + Ball.SIZE >= x && ballY + Ball.SIZE >= y && ballY <= y + height)
                b.changeXDir();
        }
    }

    public void switchDirections(int direction) {

        vel = speed * direction;
    }

    private void closeWindow() {
        if (score == 7){
            SwingUtilities.getWindowAncestor(gm).dispatchEvent
                    (new WindowEvent(SwingUtilities.getWindowAncestor(gm), WindowEvent.WINDOW_CLOSING));
            System.exit(0);
        }
    }

    public void stop() {

        vel = 0;
    }


}