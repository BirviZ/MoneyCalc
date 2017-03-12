package com.ilanta.moneyCalc.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private BanknotePanel[] panel;
    private JLabel res = new JLabel("0 грн.");

    public MainWindow() {
        setTitle("Каса");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(3, 3));
        int[] n = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        panel = new BanknotePanel[n.length];
        for (int i = 0; i < n.length; i++) {
            panel[i] = new BanknotePanel(n[i]);
            p1.add(panel[i]);
        }
        setLayout(new BorderLayout());

        JPanel result = new JPanel();

        result.setBorder(BorderFactory.createBevelBorder(1));
        result.add(res);

        add(result, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);

        JButton calc = new JButton("Порахувати");
        add(calc, BorderLayout.SOUTH);

        calc.addActionListener(e -> {
            int result1 = 0;
            for(BanknotePanel p: panel) {
                result1 += p.getResult();
            }
            res.setText(result1 + " грн.");
        });

        pack();
        setLocationRelativeTo(null);
    }
}
