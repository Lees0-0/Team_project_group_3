package org.group_3.windows;

import javax.swing.*;
import java.awt.*;

public class CreatePanel {

    public static final int TOP_INSET = 10;
    public static final int LEFT_INSET = 10;
    public static final int BOTTOM_INSET = 0;
    public static final int RIGHT_INSET = 0;

    public static GridBagConstraints gbc = new GridBagConstraints();
    public static JPanel createPanel(){
        JPanel panel = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(TOP_INSET, LEFT_INSET, BOTTOM_INSET, RIGHT_INSET);
        gbc.anchor = GridBagConstraints.CENTER;
        return panel;
    }
}