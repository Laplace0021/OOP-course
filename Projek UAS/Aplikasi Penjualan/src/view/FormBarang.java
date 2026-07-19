package view;

import controller.BarangController;
import model.Barang;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FormBarang extends JFrame {

    private final BarangController controller = new BarangController();

    private final JTextField txtKode = new JTextField(10);
    private final JTextField txtNama = new JTextField(15);
    private final JTextField txtKategori = new JTextField(10);
    private final JTextField txtHarga = new JTextField(10);
    private final JTextField txtStok = new JTextField(5);
    private final JTextField txtCari = new JTextField(15);

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Kategori", "Harga", "Stok"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    public FormBarang() {
        setTitle("Data Barang");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addField(form, gbc, 0, "Kode Barang", txtKode);
        addField(form, gbc, 1, "Nama Barang", txtNama);
        addField(form, gbc, 2, "Kategori", txtKategori);
        addField(form, gbc, 3, "Harga", txtHarga);
        addField(form, gbc, 4, "Stok", txtStok);

        JButton btnTambah = new JButton("Tambah");
        JButton btnUbah = new JButton("Ubah");
        JButton btnHapus = new JButton("Hapus");
        JButton btnBersih = new JButton("Bersihkan");

        JPanel tombolPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        tombolPanel.add(btnTambah);
        tombolPanel.add(btnUbah);
        tombolPanel.add(btnHapus);
        tombolPanel.add(btnBersih);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
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

    private void addField(JPanel form, GridBagConstraints gbc, int row, String label, JTextField field) {
        gbc.gridx = 0; gbc.gridy = row;
        form.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        form.add(field, gbc);
    }

    private void tambah() {
        try {
            Barang b = ambilDataForm();
            if (controller.tambahBarang(b)) {
                JOptionPane.showMessageDialog(this, "Barang berhasil ditambahkan");
                bersihkanForm();
                tampilkanSemua();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ubah() {
        try {
            Barang b = ambilDataForm();
            if (controller.ubahBarang(b)) {
                JOptionPane.showMessageDialog(this, "Barang berhasil diubah");
                bersihkanForm();
                tampilkanSemua();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengubah: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapus() {
        String kode = txtKode.getText().trim();
        if (kode.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus barang " + kode + "?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            controller.hapusBarang(kode);
            JOptionPane.showMessageDialog(this, "Barang berhasil dihapus");
            bersihkanForm();
            tampilkanSemua();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cari() {
        try {
            List<Barang> hasil = controller.cariBarang(txtCari.getText().trim());
            tampilKeTabel(hasil);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mencari: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilkanSemua() {
        try {
            tampilKeTabel(controller.getAllBarang());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tampilKeTabel(List<Barang> list) {
        model.setRowCount(0);
        for (Barang b : list) {
            model.addRow(new Object[]{b.getKodeBarang(), b.getNamaBarang(), b.getKategori(), b.getHarga(), b.getStok()});
        }
    }

    private void isiFormDariTabel() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        txtKode.setText(model.getValueAt(row, 0).toString());
        txtNama.setText(model.getValueAt(row, 1).toString());
        txtKategori.setText(model.getValueAt(row, 2).toString());
        txtHarga.setText(model.getValueAt(row, 3).toString());
        txtStok.setText(model.getValueAt(row, 4).toString());
    }

    private Barang ambilDataForm() {
        if (txtKode.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty()) {
            throw new IllegalArgumentException("Kode dan nama barang wajib diisi");
        }
        double harga;
        int stok;
        try {
            harga = Double.parseDouble(txtHarga.getText().trim());
            stok = Integer.parseInt(txtStok.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Harga dan stok harus berupa angka");
        }
        return new Barang(txtKode.getText().trim(), txtNama.getText().trim(),
                txtKategori.getText().trim(), harga, stok);
    }

    private void bersihkanForm() {
        txtKode.setText("");
        txtNama.setText("");
        txtKategori.setText("");
        txtHarga.setText("");
        txtStok.setText("");
        table.clearSelection();
    }
}