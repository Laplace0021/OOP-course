package dao;

import config.Koneksi;
import model.Admin;
import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return buildUser(rs);
                }
            }
        }
        return null;
    }

    public List<User> getAll() throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user ORDER BY id_user";
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(buildUser(rs));
            }
        }
        return list;
    }

    public List<User> cari(String keyword) throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM user WHERE username LIKE ? OR nama_lengkap LIKE ? ORDER BY id_user";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(buildUser(rs));
                }
            }
        }
        return list;
    }

    public boolean tambah(User user) throws SQLException {
        String sql = "INSERT INTO user (username, password, nama_lengkap, role) VALUES (?, ?, ?, ?)";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNamaLengkap());
            ps.setString(4, user.getRole());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean ubah(User user) throws SQLException {
        String sql = "UPDATE user SET username=?, password=?, nama_lengkap=?, role=? WHERE id_user=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNamaLengkap());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getIdUser());
            return ps.executeUpdate() > 0;
        }
    }

    public boolean hapus(int idUser) throws SQLException {
        String sql = "DELETE FROM user WHERE id_user=?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            return ps.executeUpdate() > 0;
        }
    }

    private User buildUser(ResultSet rs) throws SQLException {
        String role = rs.getString("role");
        if ("admin".equalsIgnoreCase(role)) {
            return new Admin(rs.getInt("id_user"), rs.getString("username"),
                    rs.getString("password"), rs.getString("nama_lengkap"));
        }
        return new User(rs.getInt("id_user"), rs.getString("username"),
                rs.getString("password"), rs.getString("nama_lengkap"),role);
    }
}