import java.awt.*;
import javax.swing.*;

public class MyForm4 extends JFrame {
   GridLayout gl = new GridLayout(3,3);   
    
    
    MyForm4(){
        super("Belajar GUI");
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        setLayout(gl);
        add(new JButton("Tombol 1"));
        add(new JButton("Tombol 2"));
        add(new JButton("Tombol 3"));
        add(new JButton("Tombol 4"));
        add(new JButton("Tombol 5"));
        add(new JButton("Tombol 6"));
        add(new JButton("Tombol 7"));
        add(new JButton("Tombol 8"));
        setVisible(true);
    }
    public static void main(String[] args) {
        MyForm4 form = new MyForm4();
    }
}
