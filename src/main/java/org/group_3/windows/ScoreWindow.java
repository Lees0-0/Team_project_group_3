package org.group_3.windows;

import javax.swing.*;
import java.awt.*;

import static org.group_3.windows.CreatePanel.gbc;

public class ScoreWindow {
    public static void createScoreWindow() {

        JFrame frame = CreateWindow.createWindow("Рахунок гри");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();

        JLabel label = new JLabel("Рахунок гри: ");
        panel.add(label);
        gbc.gridy++;
        JLabel test = new JLabel("test");
        panel.add(test, gbc);
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
        panel.add(buttonStart, gbc);
        gbc.gridx++;
        gbc.insets = new Insets(10, 10, 0, 0);
        JButton buttonEnd = new JButton("Кінець гри");
        panel.add(buttonEnd, gbc);

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
