package com.wozimer.cataloger;

import com.wozimer.cataloger.model.StartPoints;
import com.wozimer.cataloger.ui.MainFrame;

import java.io.File;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger("com.wozimer.cataloger.Main");

    public static void main(String[] args) {
        StartPoints startPoints = new StartPoints();
        startPoints.add(new File("."), "Текущий каталог");

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
