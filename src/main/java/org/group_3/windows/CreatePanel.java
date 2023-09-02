package org.group_3.windows;

import javax.swing.*;
import java.awt.*;

public class CreatePanel {
    public static GridBagConstraints gbc = new GridBagConstraints();
    public static JPanel createPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        return panel;
    }
}