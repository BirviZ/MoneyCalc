package com.ilanta.moneyCalc.ui;

import javax.swing.*;
import java.awt.*;

import com.ilanta.moneyCalc.savings.Save;

public class MainWindow extends JFrame {
    private BanknotePanel[] panel;
    private JLabel res = new JLabel("0 грн.");

    private void calculate() {
        int result1 = 0;
        for(BanknotePanel p: panel) {
            result1 += p.getResult();
        }
        res.setText(result1 + " грн.");
    }

    public MainWindow() {
        setTitle("Каса");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Image img = new ImageIcon(MainWindow.class.getResource("/res/iconMC.png")).getImage();
        setIconImage(img);
        
        try {
//            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(3, 3));
        int[] n = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        int[] values = Save.read();
        panel = new BanknotePanel[n.length];
        for (int i = 0; i < n.length; i++) {
            panel[i] = new BanknotePanel(n[i]);
            p1.add(panel[i]);
            panel[i].setQuantity(values[i]);
        }
        calculate();
        setLayout(new BorderLayout());

        JPanel result = new JPanel();

        Font resFont = new Font(Font.SANS_SERIF, Font.BOLD, 36);

        res.setFont(resFont);

        result.setBorder(BorderFactory.createEtchedBorder());
        result.add(res);

        add(result, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);

        JButton calc = new JButton("Порахувати");
        JButton reset = new JButton("Скинути");
        JButton del = new JButton("Видалити збереження");
        calc.setFont(new Font(calc.getFont().getFontName(), Font.BOLD, calc.getFont().getSize()+6));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        buttonPanel.add(reset);
        buttonPanel.add(calc);
        buttonPanel.add(del);

        add(buttonPanel, BorderLayout.SOUTH);

        calc.addActionListener(e -> {
            calculate();
            int v[] = new int[panel.length];
            for(int i = 0; i < panel.length; i++) {
                v[i] = panel[i].getQuantity();
            }
            Save.write(v);
        });

        reset.addActionListener(e -> {
            for(BanknotePanel p: panel){
                p.setQuantity(0);
            }
            res.setText("0 грн.");
        });

        del.addActionListener(e -> Save.delete());

        pack();
        setLocationRelativeTo(null);
    }
}
