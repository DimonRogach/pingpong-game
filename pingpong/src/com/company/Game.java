package com.company;

import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {
    public final static int WIDTH = 1000;
    public final static int HEIGHT = WIDTH * 9 / 16;
    Color cl;
    public boolean running = false;
    public Thread gameThread;
    private Ball ball;

    private Paddle leftPaddle;
    private Paddle rightPaddle;

    public Game() throws IOException {
        canvasSetup();
        initialise();
        this.addKeyListener(new KeyInput(leftPaddle, rightPaddle));
        this.setFocusable(true);
    }

    private void initialise() throws IOException {
        ball = new Ball();
        leftPaddle = new Paddle(this, Color.green, true);
        rightPaddle = new Paddle(this, Color.green, false);
    }

    private void canvasSetup() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void run() {
        this.requestFocus();

        long startGameTime = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                update();
                delta--;
                try {
                    draw();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }

    public void music() {
        try {
            File file = new File("music/music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            if (gameThread == null)
                clip.stop();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public synchronized void start() {
        new WinMain("PingPong", this);
        gameThread = new Thread(this);
        music();
        gameThread.start();
        running = true;
    }

    public void stop() {
        try {
            gameThread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void draw() throws IOException {
        BufferStrategy buffer = this.getBufferStrategy();
        if (buffer == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = buffer.getDrawGraphics();
        drawBackground(g);
        ball.draw(g);
        leftPaddle.draw(g);
        rightPaddle.draw(g);
        g.dispose();
        buffer.show();
    }

    private void drawBackground(Graphics g) {

        g.setColor(cl);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.white);
        Graphics2D g2d = (Graphics2D) g;

        Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]
                {10}, 0);
        g2d.setStroke(dashed);
        g.drawLine(WIDTH / 2, 0, WIDTH / 2, HEIGHT);
    }

    public void update() {
        ball.update(leftPaddle, rightPaddle);
        leftPaddle.update(ball);
        rightPaddle.update(ball);
    }

    public static int ensureRange(int value, int min, int max) {
        return Math.min(Math.max(value, min), max);
    }

    public static int sign(double d) {
        if (d <= 0)
            return -1;
        return 1;
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}