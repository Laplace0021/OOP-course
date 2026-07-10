package com.laplace.roguelike.gui;
import java.awt.*;
import javax.swing.*;

public class MenuPanel extends JPanel {
    JLabel label = new JLabel();
    MenuPanel(){
        setBackground(Color.PINK);
        setLayout(new BorderLayout());
        label.setText("Dungeon");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);

    }
}
