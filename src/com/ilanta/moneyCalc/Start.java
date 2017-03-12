package com.ilanta.moneyCalc;

import com.ilanta.moneyCalc.ui.MainWindow;

import javax.swing.*;

public class Start {
    private static MainWindow gui;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            gui = new MainWindow();
            gui.setVisible(true);
        });
    }

}