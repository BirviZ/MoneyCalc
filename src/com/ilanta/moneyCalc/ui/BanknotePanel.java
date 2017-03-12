package com.ilanta.moneyCalc.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class BanknotePanel extends JPanel {
    private JTextField textField = new JTextField(5);
    private JLabel label = new JLabel("0");
    private int quantity;
    private int nominal;

    public BanknotePanel(int nominal) {
        this.nominal = nominal;

        Border border = BorderFactory.createTitledBorder(String.valueOf(this.nominal));

        label.setHorizontalTextPosition(JLabel.RIGHT);
        label.setHorizontalAlignment(JLabel.RIGHT);

        this.setBorder(border);
        this.setLayout(new GridLayout(2, 1));
        this.add(textField);
        this.add(label);
    }
}
