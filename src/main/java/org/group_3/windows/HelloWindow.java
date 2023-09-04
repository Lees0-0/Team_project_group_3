package org.group_3.windows;

import org.group_3.EnglishWindows.EnglishGameWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import static org.group_3.windows.CreatePanel.TOP_INSET;
import static org.group_3.windows.CreatePanel.LEFT_INSET;
import static org.group_3.windows.CreatePanel.RIGHT_INSET;
import static org.group_3.windows.CreatePanel.BOTTOM_INSET;

import static org.group_3.windows.CreatePanel.gbc;

public class HelloWindow {


    public static void createHelloWindow() {


        JFrame frame = CreateWindow.createWindow("Вітаємо!");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();

        JLabel label = new JLabel("Вітаємо Вас у грі дитинства і всіх розумників! Виберіть мову гри:");
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(TOP_INSET, LEFT_INSET, BOTTOM_INSET, RIGHT_INSET);
        JButton button = new JButton("Українська!");
        panel.add(button, gbc);

        gbc.gridy++;
        gbc.insets = new Insets(TOP_INSET, LEFT_INSET, BOTTOM_INSET, RIGHT_INSET);
        JButton button2 = new JButton("English!");
        panel.add(button2, gbc);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        button.addActionListener(e -> {
            frame.dispose();
            try {
                GameWindow.createGameWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        button2.addActionListener(e -> {
            frame.dispose();
            try {
                EnglishGameWindow.createEnglishGameWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}