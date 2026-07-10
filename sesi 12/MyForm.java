import java.awt.*;
import javax.swing.*;

public class MyForm extends JFrame{
    MyForm(){
        super("Belajar GUI");
        setSize(1920,1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GREEN);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        MyForm form = new MyForm();
    }
}