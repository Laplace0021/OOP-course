package com.laplace.roguelike.gui;
import java.awt.*;
import javax.swing.*;
import com.laplace.roguelike.gui.MenuPanel;

public class MainFrame extends JFrame{
    CardLayout cl1 = new CardLayout();
    JPanel panel1 = new JPanel();
    MenuPanel menuPanel = new MenuPanel();
    MainFrame(){
        super("Dungeon");
        setSize(900,600);
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1.setLayout(cl1);
        add(panel1);
        panel1.setBackground(Color.BLUE);
        panel1.add(menuPanel,"MENU");
        cl1.show(panel1, "MENU");
        setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();

    }
}
