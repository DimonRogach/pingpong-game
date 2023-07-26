package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
public class WND extends JFrame{
    Game game;
    WND() throws IOException {
        super();
        DRW drw = new DRW();
        game = new Game();
        this.setBounds(500, 100, 400, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        this.add(drw,BorderLayout.CENTER);
        this.setTitle("Main Window");
        JPanel panel = new JPanel();
        panel.setBackground(Color.ORANGE);
        JButton button1 = new JButton("Start");
        JButton button2 = new JButton("Settings");
        JButton button3 = new JButton("Registration");
        button3.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,16));
        button2.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,16));
        button1.setFont(new Font("Arial",Font.ITALIC + Font.BOLD,16));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File fileName = new File("users.txt");
                ArrayList aList = new ArrayList();
                String user = " ";
                while(!user.isEmpty()){
                    user = JOptionPane.showInputDialog("Name a user,please");
                    if(!user.isEmpty())
                        aList.add(user);
                }
                try{
                    FileWriter fw = new FileWriter(fileName,true);
                    Writer output = new BufferedWriter(fw);
                    int sz = aList.size();
                    for(int i = 0; i<sz;i++) {
                        output.write(aList.get(i).toString() + "\n");
                    }
                    output.close();
                }
                catch (Exception exc){
                    JOptionPane.showMessageDialog(null,"good bye");
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Optns opt = new Optns(game);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        this.add(panel,BorderLayout.SOUTH);
        JPopupMenu popup = new JPopupMenu();
        JMenuItem mExit1 = new JMenuItem("Quit"),
                mAuthor1 = new JMenuItem("Author"),
                mTask1 = new JMenuItem("Info"),
                mGame1 = new JMenuItem("Game");
        popup.add(mExit1);
        popup.add(mAuthor1);
        popup.add(mTask1);
        popup.add(mGame1);
        drw.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (SwingUtilities.isRightMouseButton(e)) {
                    popup.show(drw, e.getX(), e.getY());
                }
            }
        });
        mExit1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mAuthor1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WND1 wnd1 = new WND1("Автор");
                wnd1.setTitle("Information about the author");
                wnd1.add(new DRW1());
                wnd1.setResizable(false);
            }
        });
        mTask1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WND1 wnd1 = new WND1("Завдання");
                wnd1.setTitle("Task information");
                wnd1.add(new DRW2());
                wnd1.setBounds(900, 100, 650, 500);
                wnd1.setLocationRelativeTo(null);
                wnd1.setResizable(false);
            }
        });
        mGame1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        JMenu mFile = new JMenu("Menu");
        JMenuItem mExit = new JMenuItem("Quit"),
                mAuthor = new JMenuItem("Author"),
                mTask = new JMenuItem("Info"),
                mGame = new JMenuItem("Game");
        mExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WND1 wnd1 = new WND1("Автор");
                wnd1.setTitle("Information about the author");
                wnd1.add(new DRW1());
                wnd1.setResizable(false);
            }
        });
        mTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WND1 wnd1 = new WND1("Завдання");
                wnd1.setTitle("Task information");
                wnd1.add(new DRW2());
                wnd1.setBounds(900, 100, 650, 500);
                wnd1.setLocationRelativeTo(null);
            }
        });
        mGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.start();
            }
        });
        mFile.add(mExit);
        mFile.add(mAuthor);
        mFile.add(mTask);
        mFile.add(mGame);
        mb.add(mFile);
        JMenu mOpt = new JMenu("Options");
        JMenuItem mInst = new JMenuItem("Instruction");
        mOpt.add(mInst);
        mb.add(mOpt);
        mInst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WND1 wnd1 = new WND1("Інструкція");
                wnd1.setTitle("Instructions for the game");
                wnd1.add(new DRW_1());
                wnd1.setBounds(500,100,700,500);
                wnd1.setLocationRelativeTo(null);
                wnd1.setVisible(true);
                wnd1.setResizable(false);
            }
        });
    }
}