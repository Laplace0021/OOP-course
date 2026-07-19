package view;

import controller.UserController;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FormUser extends JFrame {

    private final UserController controller = new UserController();

    private final JTextField txtId = new JTextField(5);
    private final JTextField txtUsername = new JTextField(12);
    private final JTextField txtPassword = new JTextField(12);
    private final JTextField txtNama = new JTextField(15);
    private final JComboBox<String> cbRole = new JComboBox<>(new String[]{"admin", "kasir"});
    private final JTextField txtCari = new JTextField(15);

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Username", "Nama Lengkap", "Role"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    public FormUser() {
        setTitle("Data User");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtId.setEditable(false);
        String[] labels = {"ID", "Username", "Password", "Nama Lengkap", "Role"};
        JComponent[] fields = {txtId, txtUsername, txtPassword, txtNama, cbRole};
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; gbc.gridy = i;
            form.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            form.add(fields[i], gbc);
        }

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnBersih = new JButton("Bersihkan");

        JPanel tombolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tombolPanel.add(btnTambah);
        tombolPanel.add(btnUbah);
        tombolPanel.add(btnHapus);
        tombolPanel.add(btnBersih);
        gbc.gridx = 0; gbc.gridy = labels.length; gbc.gridwidth = 2;
        form.add(tombolPanel, gbc);

        JPanel cariPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cariPanel.add(new JLabel("Cari:"));
        cariPanel.add(txtCari);
        JButton btnCari = new JButton("Cari");
        JButton btnRefresh = new JButton("Tampilkan Semua");
        cariPanel.add(btnCari);
        cariPanel.add(btnRefresh);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(form, BorderLayout.CENTER);
        topPanel.add(cariPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        btnTambah.addActionListener(e -> tambah());
        btnUbah.addActionListener(e -> ubah());
        btnHapus.addActionListener(e -> hapus());
        btnBersih.addActionListener(e -> bersihkanForm());
        btnCari.addActionListener(e -> cari());
        btnRefresh.addActionListener(e -> tampilkanSemua());
        table.getSelectionModel().addListSelectionListener(e -> isiFormDariTabel());

        tampilkanSemua();
    }

    private void tambah() {
        try {
            User u = new User();
            u.setUsername(txtUsername.getText().trim());
            u.setPassword(txtPassword.getText().trim());
            u.setNamaLengkap(txtNama.getText().trim());
            u.setRole((String) cbRole.getSelectedItem());
            controller.tambahUser(u);
            JOptionPane.showMessageDialog(this, "User berhasil ditambahkan");
            bersihkanForm();
            tampilkanSemua();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ubah() {
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu");
            return;
        }
        try {
            User u = new User();
            u.setIdUser(Integer.parseInt(txtId.getText().trim()));
            u.setUsername(txtUsername.getText().trim());
            u.setPassword(txtPassword.getText().trim());
            u.setNamaLengkap(txtNama.getText().trim());
            u.setRole((String) cbRole.getSelectedItem());
            controller.ubahUser(u);
            JOptionPane.showMessageDialog(this, "User berhasil diubah");
            bersihkanForm();
            tampilkanSemua();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapus() {
        if (txtId.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data pada tabel terlebih dahulu");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus user ini?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            controller.hapusUser(Integer.parseInt(txtId.getText().trim()));
            JOptionPane.showMessageDialog(this, "User berhasil dihapus");
            bersihkanForm();
            tampilkanSemua();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cari() {
        try {
            tampilKeTabel(controller.cariUser(txtCari.getText().trim()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencari: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanSemua() {
        try {
            tampilKeTabel(controller.getAllUser());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilKeTabel(List<User> list) {
        model.setRowCount(0);
        for (User u : list) {
            model.addRow(new Object[]{u.getIdUser(), u.getUsername(), u.getNamaLengkap(), u.getRole()});
        }
    }

    private void isiFormDariTabel() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        txtId.setText(model.getValueAt(row, 0).toString());
        txtUsername.setText(model.getValueAt(row, 1).toString());
        txtNama.setText(model.getValueAt(row, 2).toString());
        cbRole.setSelectedItem(model.getValueAt(row, 3).toString());
    }

    private void bersihkanForm() {
        txtId.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtNama.setText("");
        table.clearSelection();
    }
}