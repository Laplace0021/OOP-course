package controller;

import dao.PenjualanDAO;
import model.DetailPenjualan;
import model.Penjualan;

import java.sql.SQLException;
import java.util.List;

public class PenjualanController {

    private final PenjualanDAO penjualanDAO = new PenjualanDAO();

    public int simpanItem(int idPenjualan, int idPelanggan, String username,
                           DetailPenjualan detail) throws SQLException {
        if (detail.getQty() <= 0) {
            throw new IllegalArgumentException("Jumlah barang harus lebih dari 0");
        }
        return penjualanDAO.simpanDetailTransaksi(idPenjualan, idPelanggan, username, detail);
    }

    public List<Penjualan> getLaporanPenjualan() throws SQLException {
        return penjualanDAO.getLaporan();
    }

    public List<DetailPenjualan> getDetail(int idPenjualan) throws SQLException {
        return penjualanDAO.getDetailByIdPenjualan(idPenjualan);
    }
}