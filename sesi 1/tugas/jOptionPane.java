import javax.swing.JOptionPane;

public class jOptionPane {

    public static void main(String[] args) {
        String pelajaran = JOptionPane.showInputDialog(null, "Anda sedang belajar apa?");
        if(!pelajaran.isEmpty()){
            JOptionPane.showMessageDialog(null, "Belajar "+pelajaran+ " sangat mudah");
        }
    }
}