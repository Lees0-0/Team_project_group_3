package org.group_3.windows;

import javax.swing.*;
import static org.group_3.windows.CreatePanel.gbc;

public class GameWindow {

    private static String inputText;
    private static boolean canInput = true;

    public static void createGameWindow() {

        JFrame frame = CreateWindow.createWindow("Міста");
        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();

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
                if (inputText.equals("здаюсь")) {
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
                if (inputText.equals("здаюсь")) {
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
