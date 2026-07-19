package dao;

import config.Koneksi;
import model.Barang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BarangDAO {

    public List<Barang> getAll() throws SQLException {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang ORDER BY kode_barang";
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(buildBarang(rs));
            }
        }
        return list;
    }

    public List<Barang> cari(String keyword) throws SQLException {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang WHERE kode_barang LIKE ? OR nama_barang LIKE ? ORDER BY kode_barang";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(buildBarang(rs));
                }
            }
        }
        return list;
    }

    public boolean tambah(Barang b) throws SQLException {
        String sql = "INSERT INTO barang (kode_barang, nama_barang, kategori, harga, stok) VALUES (?,?,?,?,?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getKodeBarang());
            ps.setString(2, b.getNamaBarang());
            ps.setString(3, b.getKategori());
            ps.setDouble(4, b.getHarga());
            ps.setInt(5, b.getStok());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean ubah(Barang b) throws SQLException {
        String sql = "UPDATE barang SET nama_barang=?, kategori=?, harga=?, stok=? WHERE kode_barang=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, b.getNamaBarang());
            ps.setString(2, b.getKategori());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getStok());
            ps.setString(5, b.getKodeBarang());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean hapus(String kodeBarang) throws SQLException {
        String sql = "DELETE FROM barang WHERE kode_barang=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeBarang);
            return ps.executeUpdate() > 0;
        }
    }

    private Barang buildBarang(ResultSet rs) throws SQLException {
        return new Barang(
                rs.getString("kode_barang"),
                rs.getString("nama_barang"),
                rs.getString("kategori"),
                rs.getDouble("harga"),
                rs.getInt("stok")
        );
    }
}