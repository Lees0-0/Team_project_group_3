package org.group_3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class ScoreWindow {
    public static void createScoreWindow() {

        int width = 400;
        int height = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JFrame frame = new JFrame("Рахунок гри");

        try {
            URL iconURL = new URL("https://media.istockphoto.com/id/1486992237/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%BF%D0%BB%D0%B0%D0%B2%D0%B0%D1%8E%D1%89%D0%B0%D1%8F-%D0%B8%D0%BA%D0%BE%D0%BD%D0%BA%D0%B0-%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%B0-%D0%B2-%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B5-%D0%BB%D0%BE%D0%B3%D0%BE%D1%82%D0%B8%D0%BF.jpg?s=2048x2048&w=is&k=20&c=TBwmZ-lVliMXQ-sHNv_mlhlPo2u9t4vlzy33dcoP70k=");
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }

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
