package org.group_3.windows;

import org.group_3.GameLogic.GameLogic;

import javax.swing.*;
import java.io.IOException;

import static org.group_3.windows.CreatePanel.gbc;

public class GameWindow {

    private static int score = 0;
    public static void createGameWindow() throws IOException {

        GameLogic gameLogic = new GameLogic();

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

        gbc.gridx--;
        JLabel label2 = new JLabel("Комп'ютер: ");
        panel.add(label2, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Здаюсь");
        panel.add(button2, gbc);


        JLabel label3 = new JLabel("Рахунок: 0");
        panel.add(label3, gbc);


        button.addActionListener(e -> {
            String userInput = textField.getText().trim();

            if (gameLogic.isValidCity(userInput)) {
                JOptionPane.showMessageDialog(null,
                        "Невірне місто! Спробуйте ще раз.");
                textField.setText("");
                return;
            }

            if (GameLogic.isCityUsed(userInput)) {
                JOptionPane.showMessageDialog(null,
                        "Це місто вже було використане! Спробуйте інше місто.");
                textField.setText("");
                return;
            }

            String computerResponse = gameLogic.generateComputerResponse(userInput);

            if (GameLogic.usedCities.size() >= 2 && gameLogic.checkingFirstLastSymbol(userInput)) {
                String lastAddedCity = GameLogic.usedCities.get(GameLogic.usedCities.size() - 1);
                char lastLetter = Character.toUpperCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
                JOptionPane.showMessageDialog(null,
                        "Місто повинно починатись з " + lastLetter);
                textField.setText("");
                return;
            }
            if (computerResponse.equals("здаюсь")) {
                frame.dispose();
                ScoreWindow.createScoreWindow();
                gameLogic.clearCollections();
                ScoreWindow.getLabel().setText("Вітаємо з перемогою!");
                ScoreWindow.getLabel2().setText("Рахуноко користувача:" + score++);
                ScoreWindow.getLabel3().setText("Рахунок комп'ютера:" + score--);
            }

            if (userInput.equals("здаюсь")) {
                frame.dispose();
                ScoreWindow.createScoreWindow();
                gameLogic.clearCollections();
                ScoreWindow.getLabel().setText("Не засмучуйтесь! Спробуйте ще раз!");
                ScoreWindow.getLabel2().setText("Рахунок користувача:" + score);
                ScoreWindow.getLabel3().setText("Рахунок комп'ютера:" + score);
            } else {
                score++;
                textField.setText("");
                label2.setText("Комп'ютер: " + computerResponse);
                label3.setText("Рахунок: " + score);
                GameLogic.usedCities.add(userInput.toLowerCase());
                GameLogic.usedCities.add(computerResponse.toLowerCase());
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        button2.addActionListener(e -> {
            frame.dispose();
            ScoreWindow.createScoreWindow();
            gameLogic.clearCollections();
            ScoreWindow.getLabel().setText("Не засмучуйтесь! Спробуйте ще раз!");
            ScoreWindow.getLabel2().setText("Рахунок користувача:" + score);
            ScoreWindow.getLabel3().setText("Рахунок комп'ютера:" + score);
        });
    }
}