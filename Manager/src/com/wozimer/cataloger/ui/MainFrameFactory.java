package com.wozimer.cataloger.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrameFactory {

    public Frame createFrame() {
        JFrame frame = new JFrame("Каталогизатор");

        frame.setContentPane(new MainFrame().$$$getRootComponent$$$());

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.pack();
        frame.setLocationRelativeTo(null);

        return frame;
    }
}
