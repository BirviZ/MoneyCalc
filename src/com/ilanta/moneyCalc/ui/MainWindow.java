package com.ilanta.moneyCalc.ui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private BanknotePanel[] panel;
    private JTextField textField = new JTextField();

    public synchronized BanknotePanel[] getPanel() {
        return panel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout(3, 3));
        int[] n = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        panel = new BanknotePanel[n.length];
        for (int i = 0; i < n.length; i++) {
            panel[i] = new BanknotePanel(n[i]);
            add(panel[i]);
        }
        pack();
        setLocationRelativeTo(null);
    }
}
