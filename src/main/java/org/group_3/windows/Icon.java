package org.group_3.windows;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class Icon {
    public static void iconURL(JFrame frame){
        try {
            URL iconURL = new URL("https://media.istockphoto.com/id/1486992237/ru/%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%BD%D0%B0%D1%8F/%D0%BF%D0%BB%D0%B0%D0%B2%D0%B0%D1%8E%D1%89%D0%B0%D1%8F-%D0%B8%D0%BA%D0%BE%D0%BD%D0%BA%D0%B0-%D0%B3%D0%BE%D1%80%D0%BE%D0%B4%D0%B0-%D0%B2-%D0%B2%D0%B5%D0%BA%D1%82%D0%BE%D1%80%D0%B5-%D0%BB%D0%BE%D0%B3%D0%BE%D1%82%D0%B8%D0%BF.jpg?s=2048x2048&w=is&k=20&c=TBwmZ-lVliMXQ-sHNv_mlhlPo2u9t4vlzy33dcoP70k=");
            ImageIcon icon = new ImageIcon(iconURL);
            frame.setIconImage(icon.getImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}