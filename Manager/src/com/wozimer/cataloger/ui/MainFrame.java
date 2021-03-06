package com.wozimer.cataloger.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Модель-контроллер-фабрика главного окна.
 * <p>
 * Окно создается через статический метод {@link #createFrame()}.
 */
public class MainFrame {
    private final Collection<MainFrameListener> listeners = new ArrayList<>();
    private final JFrame frame;

    private JPanel contentPanel;
    private JButton exitButton;
    private JPanel leftPanel;
    private JButton startPointsButton;
    private JTextArea logArea;
    private JButton newFilesButton;

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    private MainFrame(JFrame frame) {
        this.frame = frame;
        frame.setContentPane($$$getRootComponent$$$());

        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                doOnExit(e.getWindow());
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Component source = (Component) e.getSource();
                Window window = findWindow(source);
                if (window != null)
                    doOnExit(window);
            }

            private Window findWindow(Component source) {
                while (source != null) {
                    if ((source instanceof Window))
                        return (Window) source;
                    source = source.getParent();
                }
                return null;
            }
        });
        newFilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doOnNewFiles();
            }
        });

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    public static MainFrame createFrame() {
        JFrame frame = new JFrame("Каталогизатор");

        final MainFrame mainFrame = new MainFrame(frame);

        return mainFrame;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void addMainFrameListener(MainFrameListener listener) {
        listeners.add(listener);
    }

    public void removeMainFrameListener(MainFrameListener listener) {
        listeners.remove(listener);
    }

    private void doOnExit(Window window) {
        for (MainFrameListener listener : listeners) {
            listener.onExit(this);
        }
        window.dispose();
    }

    private void doOnNewFiles() {
        for (MainFrameListener listener : listeners) {
            listener.onNewFiles(this);
        }
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        contentPanel.add(leftPanel, BorderLayout.WEST);
        leftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3), null));
        startPointsButton = new JButton();
        startPointsButton.setActionCommand("startPointsWindow");
        startPointsButton.setEnabled(false);
        startPointsButton.setText("Начала");
        startPointsButton.setToolTipText("Начальные точки");
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        leftPanel.add(startPointsButton, gbc);
        final JPanel spacer1 = new JPanel();
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        leftPanel.add(spacer1, gbc);
        exitButton = new JButton();
        exitButton.setActionCommand("exit");
        exitButton.setText("Выход");
        exitButton.setToolTipText("Выход из приложения");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        leftPanel.add(exitButton, gbc);
        newFilesButton = new JButton();
        newFilesButton.setText("Разобрать");
        newFilesButton.setToolTipText("Разобрать новые файлы и каталоги по категориям");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        leftPanel.add(newFilesButton, gbc);
        logArea = new JTextArea();
        logArea.setColumns(80);
        logArea.setEditable(false);
        logArea.setRows(20);
        contentPanel.add(logArea, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPanel;
    }

    public interface MainFrameListener {
        void onExit(MainFrame mainFrame);

        void onNewFiles(MainFrame mainFrame);
    }
}
