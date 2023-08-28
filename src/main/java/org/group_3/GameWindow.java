package org.group_3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class GameWindow {

    private static String inputText;
    private static boolean canInput = true;

    public static void createGameWindow() {

        int width = 400;
        int height = 200;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        JFrame frame = new JFrame("Міста");

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

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        JTextField textField = new JTextField(10);
        panel.add(textField, gbc);
        gbc.gridx++;
        JLabel label = new JLabel("Введіть назву міста");
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.gridx--;
        JButton button = new JButton("Зробити хід");
        panel.add(button, gbc);

        gbc.gridx++;
        JLabel label2 = new JLabel("Комп'ютер: ");
        panel.add(label2, gbc);

        textField.addActionListener(e -> {
            if (canInput) {
                inputText = textField.getText();
                if(inputText.equals("здаюсь")){
                    frame.dispose();
                    ScoreWindow.createScoreWindow();
                } else {
                    System.out.println(inputText);
                    canInput = false;
                    textField.setText("");
                }
            }
        });

        button.addActionListener(e -> {
            if (canInput) {
                inputText = textField.getText();
                if(inputText.equals("здаюсь")){
                    frame.dispose();
                    ScoreWindow.createScoreWindow();
                } else {
                    System.out.println(inputText);
                    canInput = false;
                    textField.setText("");
                }
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
