import javax.swing.*;
import java.awt.*;

public class biodataMahasiswa extends JFrame {
    private JTextField txtNim, txtNama, txtProdi;
    private JTextArea txtOutput;
    public biodataMahasiswa(){
        super("Aplikasi Biodata Mahasiswa");
        setSize(650,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel input = new JPanel(new BorderLayout());
        JPanel form = new JPanel(new GridLayout(3,2,10,10));;
        form.setBorder(BorderFactory.createTitledBorder("InputData"));
        txtNim = new JTextField(20);
        txtNama = new JTextField(20);
        txtProdi = new JTextField(20);
        form.add(new JLabel("NIM"));
        form.add(txtNim);
        form.add(new JLabel("Nama"));
        form.add(txtNama);
        form.add(new JLabel("Program Studi"));
        form.add(txtProdi);

        JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER,15,10));
        JButton show = new JButton("Tampilkan");
        JButton reset = new JButton("Reset");
        button.add(show);
        button.add(reset);
        
        input.add(form, BorderLayout.NORTH);
        input.add(button, BorderLayout.CENTER);
        add(input,BorderLayout.NORTH);

        JPanel output = new JPanel(new BorderLayout());
        output.setBorder(BorderFactory.createTitledBorder("Output"));
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 14));

        output.add(new JScrollPane(txtOutput),BorderLayout.CENTER);
        add(output, BorderLayout.CENTER);

        show.addActionListener(e -> showData());
        reset.addActionListener(e -> resetOutput());
    }
    public void showData(){
        String Nim = txtNim.getText();
        String Nama = txtNama.getText();
        String Prodi = txtProdi.getText();

        StringBuilder sb = new StringBuilder();
        sb.append("========== BIODATA MAHASISWA ==========\n\n");
        sb.append(String.format("%-15s: %s%n", "NIM", Nim));
        sb.append(String.format("%-15s: %s%n", "Nama", Nama));
        sb.append(String.format("%-15s: %s%n", "Program Studi", Prodi));

        txtOutput.setText(sb.toString());
    }

    public void resetOutput(){
        txtOutput.setText("");
    }

    public static void main(String[] args) {
        biodataMahasiswa bio = new biodataMahasiswa();
        bio.setVisible(true);
    }
}
