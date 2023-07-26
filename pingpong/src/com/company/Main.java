package com.company;
import java.io.IOException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class Main {
    public static void main(String[] args) throws IOException {
        WND wnd = new WND();
        wnd.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}