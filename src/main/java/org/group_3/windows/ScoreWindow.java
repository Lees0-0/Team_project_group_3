package org.group_3.windows;

import javax.swing.*;
import java.awt.*;

import static org.group_3.windows.CreatePanel.gbc;

public class ScoreWindow {

    static JLabel label = new JLabel();

    static JLabel label2 = new JLabel();

    public static JLabel getLabel() {
        return label;
    }

    public static JLabel getLabel2() {
        return label2;
    }
    public static void createScoreWindow() {

        JFrame frame = CreateWindow.createWindow("Рахунок гри");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();
        gbc.gridx++;
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.gridy++;
        panel.add(label2, gbc);

        gbc.gridy++;
        gbc.gridx++;
        JButton buttonStart = new JButton("Почати заново");
        panel.add(buttonStart, gbc);

        gbc.gridx--;
        gbc.insets = new Insets(10, 10, 0, 0);
        JButton buttonEnd = new JButton("Кінець гри");
        panel.add(buttonEnd, gbc);

        buttonStart.addActionListener(e -> {
            frame.dispose();
            HelloWindow.createHelloWindow();
        });
        buttonEnd.addActionListener(e -> System.exit(0));

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}