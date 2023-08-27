package org.example;

import javax.swing.*;
import java.awt.*;

public class HelloWindow {

    public static void createHelloWindow() {
        int width = 400;
        int height = 100;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JFrame frame = new JFrame("Вітаємо!");
        frame.setSize(width,height);
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();


        JLabel label = new JLabel("Вітаємо Вас у грі дитинства і всіх розумників!");
        JButton button = new JButton("Старт!");
        panel.add(label);
        panel.add(button);
        frame.getContentPane().add(panel);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createHelloWindow();
            }
        });
    }
}
