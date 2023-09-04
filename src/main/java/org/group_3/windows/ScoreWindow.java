package org.group_3.windows;

import javax.swing.*;
import java.awt.*;

import static org.group_3.windows.CreatePanel.gbc;
import static org.group_3.windows.CreatePanel.TOP_INSET;
import static org.group_3.windows.CreatePanel.LEFT_INSET;
import static org.group_3.windows.CreatePanel.RIGHT_INSET;
import static org.group_3.windows.CreatePanel.BOTTOM_INSET;



public class ScoreWindow {

    static JLabel label = new JLabel();

    static JLabel label2 = new JLabel();

    static JLabel label3 = new JLabel();

    public static JLabel getLabel() {
        return label;
    }

    public static JLabel getLabel2() {
        return label2;
    }
    public static JLabel getLabel3() {
        return label3;
    }
    public static void createScoreWindow() {

        JFrame frame = CreateWindow.createWindow("Рахунок гри");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();
        gbc.gridx++;
        panel.add(label, gbc);

        gbc.gridy++;
        panel.add(label2, gbc);

        gbc.gridy++;
        panel.add(label3, gbc);

        gbc.gridy++;
        gbc.gridx++;
        JButton buttonStart = new JButton("Почати заново");
        panel.add(buttonStart, gbc);

        gbc.gridx--;
        gbc.insets = new Insets(TOP_INSET, LEFT_INSET, BOTTOM_INSET, RIGHT_INSET);
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