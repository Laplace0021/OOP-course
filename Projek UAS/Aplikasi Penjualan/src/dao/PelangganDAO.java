package dao;

import config.Koneksi;
import model.Pelanggan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PelangganDAO {

    public List<Pelanggan> getAll() throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan ORDER BY id_pelanggan";
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(buildPelanggan(rs));
            }
        }
        return list;
    }

    public List<Pelanggan> cari(String keyword) throws SQLException {
        List<Pelanggan> list = new ArrayList<>();
        String sql = "SELECT * FROM pelanggan WHERE nama_pelanggan LIKE ? OR no_telp LIKE ? ORDER BY id_pelanggan";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(buildPelanggan(rs));
                }
            }
        }
        return list;
    }

    public boolean tambah(Pelanggan p) throws SQLException {
        String sql = "INSERT INTO pelanggan (nama_pelanggan, alamat, no_telp) VALUES (?,?,?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNamaPelanggan());
            ps.setString(2, p.getAlamat());
            ps.setString(3, p.getNoTelp());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean ubah(Pelanggan p) throws SQLException {
        String sql = "UPDATE pelanggan SET nama_pelanggan=?, alamat=?, no_telp=? WHERE id_pelanggan=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getNamaPelanggan());
            ps.setString(2, p.getAlamat());
            ps.setString(3, p.getNoTelp());
            ps.setInt(4, p.getIdPelanggan());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean hapus(int idPelanggan) throws SQLException {
        String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPelanggan);
            return ps.executeUpdate() > 0;
        }
    }

    private Pelanggan buildPelanggan(ResultSet rs) throws SQLException {
        return new Pelanggan(
                rs.getInt("id_pelanggan"),
                rs.getString("nama_pelanggan"),
                rs.getString("alamat"),
                rs.getString("no_telp")
        );
    }
}