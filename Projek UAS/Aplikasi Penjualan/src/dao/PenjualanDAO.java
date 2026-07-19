package dao;

import config.Koneksi;
import model.DetailPenjualan;
import model.Penjualan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PenjualanDAO {

    public int simpanDetailTransaksi(int idPenjualan, int idPelanggan, String username, DetailPenjualan detail) throws SQLException {
        String sql = "{call sp_tambah_penjualan(?,?,?,?,?,?,?,?)}";
        try (Connection conn = Koneksi.getConnection();
             CallableStatement cs = conn.prepareCall(sql)) {
            cs.setInt(1, idPenjualan);
            if (idPelanggan == 0) {
                cs.setNull(2, Types.INTEGER);
            } else {
                cs.setInt(2, idPelanggan);
            }
            cs.setString(3, username);
            cs.setString(4, detail.getKodeBarang());
            cs.setString(5, detail.getNamaBarang());
            cs.setDouble(6, detail.getHarga());
            cs.setInt(7, detail.getQty());
            cs.registerOutParameter(8, Types.INTEGER);

            cs.execute();
            return cs.getInt(8);
        }
    }

    public List<Penjualan> getLaporan() throws SQLException {
        List<Penjualan> list = new ArrayList<>();
        String sql = "SELECT * FROM v_laporan_penjualan";
        try (Connection conn = Koneksi.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Penjualan p = new Penjualan();
                p.setIdPenjualan(rs.getInt("id_penjualan"));
                p.setTanggal(rs.getTimestamp("tanggal"));
                p.setNamaPelanggan(rs.getString("nama_pelanggan"));
                p.setUsername(rs.getString("kasir"));
                p.setTotal(rs.getDouble("total"));
                list.add(p);
            }
        }
        return list;
    }

    public List<DetailPenjualan> getDetailByIdPenjualan(int idPenjualan) throws SQLException {
        List<DetailPenjualan> list = new ArrayList<>();
        String sql = "SELECT * FROM detail_penjualan WHERE id_penjualan = ?";
        try (Connection conn = Koneksi.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPenjualan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DetailPenjualan d = new DetailPenjualan();
                    d.setIdDetail(rs.getInt("id_detail"));
                    d.setIdPenjualan(rs.getInt("id_penjualan"));
                    d.setKodeBarang(rs.getString("kode_barang"));
                    d.setNamaBarang(rs.getString("nama_barang"));
                    d.setHarga(rs.getDouble("harga"));
                    d.setQty(rs.getInt("qty"));
                    d.setSubtotal(rs.getDouble("subtotal"));
                    list.add(d);
                }
            }
        }
        return list;
    }
}