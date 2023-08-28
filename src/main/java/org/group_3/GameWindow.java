package org.group_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameWindow extends JFrame {
    private int moveCounter = 0;
    static List<String> usedCities = new ArrayList<>();
    public GameWindow() throws HeadlessException {
        GameLogic gameLogic = new GameLogic();
        setTitle("Cities");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        JPanel panel = new JPanel(new FlowLayout());

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 30));
        panel.add(textField);

        JLabel label = new JLabel("Введіть назву міста");
        panel.add(label);


        JButton makeAMoveButton = new JButton("Зробити хід");
        panel.add(makeAMoveButton);
        JButton giveUpButton = new JButton("Здаюсь");
        panel.add(giveUpButton);
        JLabel computerResponseLabel = new JLabel();
        makeAMoveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userInput = textField.getText().trim();


                if (!gameLogic.isValidCity(userInput)) {
                    JOptionPane.showMessageDialog(GameWindow.this,
                            "Невірне місто! Спробуйте ще раз.");
                    textField.setText("");
                    return;
                }

                if (isCityUsed(userInput)) {
                    JOptionPane.showMessageDialog(GameWindow.this,
                            "Це місто вже було використане! Спробуйте інше місто.");
                    textField.setText("");
                    return;
                }

                String computerResponse = gameLogic.generateComputerResponse(userInput);

                if (usedCities.size() >= 2 && checkingFirstLastSymbol(userInput)) {
                    String lastAddedCity = usedCities.get(usedCities.size() - 1);
                    char lastLetter = Character.toUpperCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
                    JOptionPane.showMessageDialog(GameWindow.this,
                            "Місто повинно починатись з " + lastLetter);
                    textField.setText("");
                    return;
                }

                if (computerResponse.equals("Комп'ютер не знайшов відповідного міста.")) {
                    GameWonWindow gameWonWindow = new GameWonWindow(moveCounter);
                    gameWonWindow.setVisible(true);
                    moveCounter++;
                    gameLogic.clearCollections();
                    resetGame();
                    dispose();

                } else {
                    textField.setText("");
                    computerResponseLabel.setText("Відповідь комп'ютера: " + computerResponse);
                    usedCities.add(userInput.toLowerCase());
                    usedCities.add(computerResponse.toLowerCase());
                    moveCounter++;

                }



                
            }
        });
        giveUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameLostWindow gameLostWindow = new GameLostWindow(moveCounter);
                gameLostWindow.setVisible(true);
                resetGame();
                gameLogic.clearCollections();
                dispose();
            }
        });


        panel.add(computerResponseLabel);

        add(panel);


    }
    public static boolean isCityUsed(String city) {
        for (String citys: usedCities) {
            if(citys.equalsIgnoreCase(city)){
                return true;
            }
        }
        return false;
    }
    public boolean checkingFirstLastSymbol(String userInput){
        char firstLetter = Character.toLowerCase(userInput.charAt(0));
        String lastAddedCity = usedCities.get(usedCities.size() - 1);
        char lastLetter = Character.toLowerCase(lastAddedCity.charAt(lastAddedCity.length() - 1));
        if (firstLetter != lastLetter ){
            return true;
        }
        return false;
    }
    public void resetGame() {
        moveCounter = 0;
        usedCities.clear();
    }


}
