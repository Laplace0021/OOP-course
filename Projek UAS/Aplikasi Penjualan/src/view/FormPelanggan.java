package view;

import controller.PelangganController;
import model.Pelanggan;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FormPelanggan extends JFrame {

    private final PelangganController controller = new PelangganController();

    private final JTextField txtId = new JTextField(5);
    private final JTextField txtNama = new JTextField(15);
    private final JTextField txtAlamat = new JTextField(20);
    private final JTextField txtTelp = new JTextField(12);
    private final JTextField txtCari = new JTextField(15);

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"ID", "Nama Pelanggan", "Alamat", "No. Telp"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    public FormPelanggan() {
        setTitle("Data Pelanggan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("ID (kosongkan saat tambah)"), gbc);
        gbc.gridx = 1;
        txtId.setEditable(false);
        form.add(txtId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Nama Pelanggan"), gbc);
        gbc.gridx = 1;
        form.add(txtNama, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Alamat"), gbc);
        gbc.gridx = 1;
        form.add(txtAlamat, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        form.add(new JLabel("No. Telp"), gbc);
        gbc.gridx = 1;
        form.add(txtTelp, gbc);

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnBersih = new JButton("Bersihkan");

        JPanel tombolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tombolPanel.add(btnTambah);
        tombolPanel.add(btnUbah);
        tombolPanel.add(btnHapus);
        tombolPanel.add(btnBersih);
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
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
            if (txtNama.getText().trim().isEmpty()) {
                throw new IllegalArgumentException("Nama pelanggan wajib diisi");
            }
            Pelanggan p = new Pelanggan(0, txtNama.getText().trim(), txtAlamat.getText().trim(), txtTelp.getText().trim());
            controller.tambahPelanggan(p);
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil ditambahkan");
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
            Pelanggan p = new Pelanggan(Integer.parseInt(txtId.getText().trim()),
                    txtNama.getText().trim(), txtAlamat.getText().trim(), txtTelp.getText().trim());
            controller.ubahPelanggan(p);
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil diubah");
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
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus pelanggan ini?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            controller.hapusPelanggan(Integer.parseInt(txtId.getText().trim()));
            JOptionPane.showMessageDialog(this, "Pelanggan berhasil dihapus");
            bersihkanForm();
            tampilkanSemua();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cari() {
        try {
            tampilKeTabel(controller.cariPelanggan(txtCari.getText().trim()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencari: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanSemua() {
        try {
            tampilKeTabel(controller.getAllPelanggan());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilKeTabel(List<Pelanggan> list) {
        model.setRowCount(0);
        for (Pelanggan p : list) {
            model.addRow(new Object[]{p.getIdPelanggan(), p.getNamaPelanggan(), p.getAlamat(), p.getNoTelp()});
        }
    }

    private void isiFormDariTabel() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        txtId.setText(model.getValueAt(row, 0).toString());
        txtNama.setText(model.getValueAt(row, 1).toString());
        txtAlamat.setText(model.getValueAt(row, 2).toString());
        txtTelp.setText(model.getValueAt(row, 3).toString());
    }

    private void bersihkanForm() {
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelp.setText("");
        table.clearSelection();
    }
}