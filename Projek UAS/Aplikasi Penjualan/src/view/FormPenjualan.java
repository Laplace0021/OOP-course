package view;

import controller.BarangController;
import controller.PelangganController;
import controller.PenjualanController;
import model.Barang;
import model.DetailPenjualan;
import model.Pelanggan;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class FormPenjualan extends JFrame {

    private final User kasir;
    private final BarangController barangController = new BarangController();
    private final PelangganController pelangganController = new PelangganController();
    private final PenjualanController penjualanController = new PenjualanController();

    private final JComboBox<Pelanggan> cbPelanggan = new JComboBox<>();
    private final JComboBox<Barang> cbBarang = new JComboBox<>();
    private final JTextField txtQty = new JTextField(5);
    private final JLabel lblTotal = new JLabel("Rp 0");

    private final DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Kode", "Nama Barang", "Harga", "Qty", "Subtotal"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private final JTable table = new JTable(model);

    private int idPenjualanBerjalan = 0;
    private double totalBerjalan = 0;

    public FormPenjualan(User kasir) {
        this.kasir = kasir;

        setTitle("Transaksi Penjualan");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(750, 500);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Pelanggan"), gbc);
        gbc.gridx = 1;
        form.add(cbPelanggan, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        form.add(new JLabel("Barang"), gbc);
        gbc.gridx = 1;
        form.add(cbBarang, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        form.add(new JLabel("Jumlah"), gbc);
        gbc.gridx = 1;
        form.add(txtQty, gbc);

        JButton btnTambahItem = new JButton("Tambah ke Transaksi");
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        form.add(btnTambahItem, gbc);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal.setFont(new Font("SansSerif", Font.BOLD, 16));
        totalPanel.add(new JLabel("Total: "));
        totalPanel.add(lblTotal);
        JButton btnSelesai = new JButton("Selesai & Simpan Transaksi");
        JButton btnBaru = new JButton("Transaksi Baru");

        JPanel aksiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        aksiPanel.add(btnSelesai);
        aksiPanel.add(btnBaru);

        bottomPanel.add(totalPanel, BorderLayout.NORTH);
        bottomPanel.add(aksiPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        btnTambahItem.addActionListener(e -> tambahItem());
        btnSelesai.addActionListener(e -> selesaikanTransaksi());
        btnBaru.addActionListener(e -> transaksiBaru());

        muatPelanggan();
        muatBarang();
    }

    private void muatPelanggan() {
        cbPelanggan.removeAllItems();
        cbPelanggan.addItem(null);
        try {
            List<Pelanggan> list = pelangganController.getAllPelanggan();
            for (Pelanggan p : list) {
                cbPelanggan.addItem(p);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat pelanggan: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void muatBarang() {
        cbBarang.removeAllItems();
        try {
            List<Barang> list = barangController.getAllBarang();
            for (Barang b : list) {
                cbBarang.addItem(b);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal memuat barang: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tambahItem() {
        Barang barang = (Barang) cbBarang.getSelectedItem();
        if (barang == null) {
            JOptionPane.showMessageDialog(this, "Pilih barang terlebih dahulu");
            return;
        }
        int qty;
        try {
            qty = Integer.parseInt(txtQty.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Jumlah harus berupa angka");
            return;
        }
        if (qty <= 0) {
            JOptionPane.showMessageDialog(this, "Jumlah harus lebih dari 0");
            return;
        }
        if (qty > barang.getStok()) {
            JOptionPane.showMessageDialog(this, "Stok tidak mencukupi. Sisa stok: " + barang.getStok());
            return;
        }

        try {
            Pelanggan pelanggan = (Pelanggan) cbPelanggan.getSelectedItem();
            int idPelanggan = (pelanggan != null) ? pelanggan.getIdPelanggan() : 0;

            DetailPenjualan detail = new DetailPenjualan(barang.getKodeBarang(), barang.getNamaBarang(),
                    barang.getHarga(), qty);

            idPenjualanBerjalan = penjualanController.simpanItem(
                    idPenjualanBerjalan, idPelanggan, kasir.getUsername(), detail);

            model.addRow(new Object[]{barang.getKodeBarang(), barang.getNamaBarang(),
                    barang.getHarga(), qty, detail.getSubtotal()});

            totalBerjalan += detail.getSubtotal();
            lblTotal.setText(formatRupiah(totalBerjalan));

            txtQty.setText("");
            muatBarang();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Validasi", JOptionPane.WARNING_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan item: " + ex.getMessage(),
                    "Error Database", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void selesaikanTransaksi() {
        if (idPenjualanBerjalan == 0) {
            JOptionPane.showMessageDialog(this, "Belum ada item pada transaksi ini");
            return;
        }
        JOptionPane.showMessageDialog(this,
                "Transaksi #" + idPenjualanBerjalan + " tersimpan.\nTotal: " + formatRupiah(totalBerjalan),
                "Transaksi Selesai", JOptionPane.INFORMATION_MESSAGE);
        transaksiBaru();
    }

    private void transaksiBaru() {
        idPenjualanBerjalan = 0;
        totalBerjalan = 0;
        model.setRowCount(0);
        lblTotal.setText(formatRupiah(0));
        muatBarang();
    }

    private String formatRupiah(double nilai) {
        return String.format("Rp %,.0f", nilai);
    }
}