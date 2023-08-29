package org.group_3.windows;

import javax.swing.*;
import java.awt.*;
import static org.group_3.windows.CreatePanel.gbc;

public class HelloWindow {

    public static void createHelloWindow() {


        JFrame frame = CreateWindow.createWindow("Вітаємо!");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();

        JLabel label = new JLabel("Вітаємо Вас у грі дитинства і всіх розумників!");
        panel.add(label, gbc);
        gbc.gridx++;
        gbc.insets = new Insets(10, 10, 0, 0);
        JButton button = new JButton("Старт!");
        panel.add(button, gbc);

        button.addActionListener(e -> {
            frame.dispose();
            GameWindow.createGameWindow();
        });
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
