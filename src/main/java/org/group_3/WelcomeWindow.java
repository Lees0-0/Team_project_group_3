package org.group_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeWindow extends JFrame {
public WelcomeWindow() throws HeadlessException {
    setTitle("Cities");
    setSize(400, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screenSize.width - getWidth()) / 2;
    int y = (screenSize.height - getHeight()) / 2;
    setLocation(x, y);

    JPanel panel = new JPanel(new FlowLayout());

    JLabel label = new JLabel("Вітаємо Вас у грі");
    panel.add(label);

    JButton startButton = new JButton("Почати гру");
    startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            GameWindow gameWindow = new GameWindow();
            gameWindow.setVisible(true);
            dispose();
        }
    });
    panel.add(startButton);

    add(panel);
}
}
