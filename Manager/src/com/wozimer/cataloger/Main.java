package com.wozimer.cataloger;

import com.wozimer.cataloger.ui.MainFrameFactory;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        MainFrameFactory mainFrameFactory = new MainFrameFactory();
        Frame mainFrame = mainFrameFactory.createFrame();
        mainFrame.setVisible(true);
    }
}
