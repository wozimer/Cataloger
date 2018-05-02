package com.wozimer.cataloger;

import com.wozimer.cataloger.ui.MainFrame;

import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger("com.wozimer.cataloger.Main");

    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.createFrame();
        mainFrame.addMainFrameListener(new MainFrame.MainFrameListener() {
            @Override
            public void onExit(MainFrame mainFrame) {

            }

            @Override
            public void onNewFiles(MainFrame mainFrame) {

            }
        });
        mainFrame.getFrame().setVisible(true);
    }
}
