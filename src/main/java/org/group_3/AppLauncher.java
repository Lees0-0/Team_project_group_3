package org.group_3;
import org.group_3.windows.HelloWindow;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HelloWindow::createHelloWindow);
    }
}
