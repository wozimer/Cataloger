package com.wozimer.cataloger.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrameFactory {

    public Frame createFrame() {
        JFrame frame = new JFrame();

        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }
}
