package com.ilanta.moneyCalc.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class BanknotePanel extends JPanel {
    private JTextField textField = new JTextField("0",10);
    private JLabel label = new JLabel("0 грн.");
    private int quantity;
    private int result;

    public int getResult() {
        return result;
    }

    BanknotePanel(int nom) {

        final int nominal = nom;

        Border border = BorderFactory.createTitledBorder(String.valueOf(nominal));

        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setHorizontalAlignment(JLabel.RIGHT);

        textField.setHorizontalAlignment(JLabel.RIGHT);

        this.setBorder(border);
        this.setLayout(new GridLayout(2, 1));
        this.add(textField);
        this.add(label);

        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setSelectionStart(0);
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    quantity = Integer.valueOf(textField.getText());
                } catch (NumberFormatException except) {
                    quantity = 0;
                    textField.setText("0");
                }
                result = quantity*nominal;
                label.setText(String.valueOf(result).concat(" грн."));
            }
        });
    }
}