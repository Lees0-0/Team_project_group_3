package org.group_3.EnglishWindows;

import org.group_3.windows.CreatePanel;
import org.group_3.windows.CreateWindow;
import org.group_3.windows.HelloWindow;
import org.group_3.windows.Icon;

import javax.swing.*;
import java.awt.*;

import static org.group_3.windows.CreatePanel.gbc;

public class EnglishScoreWindow {

    static JLabel label = new JLabel();

    static JLabel label2 = new JLabel();

    public static JLabel getLabel() {
        return label;
    }

    public static JLabel getLabel2() {
        return label2;
    }
    public static void createScoreWindow() {

        JFrame frame = CreateWindow.createWindow("Score:");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();
        gbc.gridx++;
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.gridy++;
        panel.add(label2, gbc);

        gbc.gridy++;
        gbc.gridx++;
        JButton buttonStart = new JButton("Start over");
        panel.add(buttonStart, gbc);

        gbc.gridx--;
        gbc.insets = new Insets(10, 10, 0, 0);
        JButton buttonEnd = new JButton("End of the game");
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