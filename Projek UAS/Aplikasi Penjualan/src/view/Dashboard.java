package view;

import model.User;
import report.LaporanPenjualan;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    private final User user;

    public Dashboard(User user) {
        this.user = user;

        setTitle("Dashboard - Aplikasi Penjualan");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblWelcome = new JLabel("Selamat datang, " + user + " | " + user.displayMenu(),
                SwingConstants.CENTER);
        lblWelcome.setFont(new Font("SansSerif", Font.PLAIN, 12));
        panel.add(lblWelcome, BorderLayout.NORTH);

        JPanel menuPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JButton btnBarang = new JButton("Data Barang");
        JButton btnPelanggan = new JButton("Data Pelanggan");
        JButton btnTransaksi = new JButton("Transaksi Penjualan");
        JButton btnLaporan = new JButton("Laporan Penjualan");
        JButton btnUser = new JButton("Data User");
        JButton btnLogout = new JButton("Logout");

        menuPanel.add(btnBarang);
        menuPanel.add(btnPelanggan);
        menuPanel.add(btnTransaksi);
        menuPanel.add(btnLaporan);
        menuPanel.add(btnUser);
        menuPanel.add(btnLogout);

        btnUser.setEnabled("admin".equalsIgnoreCase(user.getRole()));

        panel.add(menuPanel, BorderLayout.CENTER);
        add(panel);

        btnBarang.addActionListener(e -> new FormBarang().setVisible(true));
        btnPelanggan.addActionListener(e -> new FormPelanggan().setVisible(true));
        btnTransaksi.addActionListener(e -> new FormPenjualan(user).setVisible(true));
        btnLaporan.addActionListener(e -> new LaporanPenjualan().setVisible(true));
        btnUser.addActionListener(e -> new FormUser().setVisible(true));
        btnLogout.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }
}