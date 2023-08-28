package org.group_3;

import javax.swing.*;
import java.awt.*;

public class ScoreWindow {
    public static void createScoreWindow() {

        int width = 400;
        int height = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JFrame frame = new JFrame("Рахунок гри");
        frame.setSize(width, height);
        int x = (screenWidth - width) / 2;
        int y = (screenHeight - height) / 2;
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());

        JLabel label = new JLabel("Рахунок гри: ");
        panel.add(label);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        JLabel test = new JLabel("test");
        panel.add(test,gbc);
        /*додати умову з виграшем програми та виграшем користувача
        if(){
            JLabel winLabel = new JLabel("Вітаємо з перемогою!");
            panel.add(winLabel, gbc);
        } else {
            JLabel loseLabel = new JLabel("Не засмучуйтесь! Спробуйте ще раз!");
            panel.add(loseLabel, gbc);
        }*/

        gbc.gridy++;
        JButton buttonStart = new JButton("Почати заново");
        panel.add(buttonStart,gbc);
        gbc.gridx++;
        gbc.insets = new Insets(10, 10, 0, 0);
        JButton buttonEnd = new JButton("Кінець гри");
        panel.add(buttonEnd,gbc);

        buttonStart.addActionListener(e -> {
            frame.dispose();
            HelloWindow.createHelloWindow();
        });
        buttonEnd.addActionListener(e -> {
            System.exit(0);
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
