package org.group_3.EnglishWindows;

import org.group_3.windows.CreatePanel;
import org.group_3.windows.CreateWindow;
import org.group_3.windows.Icon;

import javax.swing.*;
import java.io.IOException;

import static org.group_3.windows.CreatePanel.gbc;

public class EnglishGameWindow {

    private static int score = 0;
    public static void resetScore() {
        score = 0;
    }

    public static void createEnglishGameWindow() throws IOException {

        EnglishGameLogic englishGameLogic = new EnglishGameLogic();

        resetScore();
        JFrame frame = CreateWindow.createWindow("Cities");

        Icon.iconURL(frame);
        JPanel panel = CreatePanel.createPanel();

        JTextField textField = new JTextField(10);
        panel.add(textField, gbc);

        gbc.gridx++;
        JLabel label = new JLabel("Enter the name of the city");
        panel.add(label, gbc);

        gbc.gridy++;
        gbc.gridx--;
        JButton button = new JButton("Make a move");
        panel.add(button, gbc);

        gbc.gridx--;
        JLabel label2 = new JLabel("Computer: ");
        panel.add(label2, gbc);

        gbc.gridy++;
        JButton button2 = new JButton("Give up");
        panel.add(button2, gbc);


        JLabel label3 = new JLabel("Score: 0");
        panel.add(label3, gbc);


        button.addActionListener(e -> {
            String userInput = textField.getText().trim();

            if (englishGameLogic.isValidCity(userInput)) {
                JOptionPane.showMessageDialog(null,
                        "The wrong city! Try again.");
                textField.setText("");
                return;
            }

            if (EnglishGameLogic.isCityUsed(userInput)) {
                JOptionPane.showMessageDialog(null,
                        "This city has already been taken! Try another city.");
                textField.setText("");
                return;
            }

            String computerResponse = englishGameLogic.generateComputerResponse(userInput);

            if (EnglishGameLogic.usedCities.size() >= 2 && englishGameLogic.checkingFirstLastSymbol(userInput)) {
                String lastAddedCity = EnglishGameLogic.usedCities.get(EnglishGameLogic.usedCities.size() - 1);
                char lastLetter = Character.toUpperCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
                JOptionPane.showMessageDialog(null,
                        "The city should start with " + lastLetter);
                textField.setText("");
                return;
            }
            if (computerResponse.equals("give up")) {
                score++;
                frame.dispose();
                EnglishScoreWindow.createScoreWindow();
                englishGameLogic.clearCollections();
                EnglishScoreWindow.getLabel().setText("Congratulations!");
                EnglishScoreWindow.getLabel2().setText("Score: " + score);
            }

            if (userInput.equals("give up")) {
                frame.dispose();
                EnglishScoreWindow.createScoreWindow();
            } else {
                score++;
                textField.setText("");
                label2.setText("Computer: " + computerResponse);
                label3.setText("Score: " + score);
                EnglishGameLogic.usedCities.add(userInput.toLowerCase());
                EnglishGameLogic.usedCities.add(computerResponse.toLowerCase());
            }
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        button2.addActionListener(e -> {
            frame.dispose();
            EnglishScoreWindow.createScoreWindow();
            englishGameLogic.clearCollections();
            EnglishScoreWindow.getLabel().setText("Don't be upset! Try again!");
            EnglishScoreWindow.getLabel2().setText("Score:" + score);
        });
    }
}