package com.ilanta.moneyCalc;

import com.ilanta.moneyCalc.ui.BanknotePanel;
import com.ilanta.moneyCalc.ui.MainWindow;

import javax.swing.*;

public class Start {
    private static MainWindow gui;
    private static BanknotePanel[] panels;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                gui = new MainWindow();
                gui.setVisible(true);

            }
        });

        Thread thread = new Thread(() -> {
            while (gui == null) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            panels = gui.getPanel(); //gui = NULL
            System.out.println(panels.length);
        });
        thread.start();
//        panels = gui.getPanel(); //gui = NULL
//        System.out.println(panels.length);

    }

}
