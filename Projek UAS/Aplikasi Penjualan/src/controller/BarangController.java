package controller;

import dao.BarangDAO;
import model.Barang;

import java.sql.SQLException;
import java.util.List;

public class BarangController {

    private final BarangDAO barangDAO = new BarangDAO();

    public List<Barang> getAllBarang() throws SQLException {
        return barangDAO.getAll();
    }

    public List<Barang> cariBarang(String keyword) throws SQLException {
        return barangDAO.cari(keyword);
    }

    public boolean tambahBarang(Barang b) throws SQLException {
        validasi(b);
        return barangDAO.tambah(b);
    }

    public boolean ubahBarang(Barang b) throws SQLException {
        validasi(b);
        return barangDAO.ubah(b);
    }

    public boolean hapusBarang(String kodeBarang) throws SQLException {
        return barangDAO.hapus(kodeBarang);
    }

    private void validasi(Barang b) {
        if (b.getKodeBarang() == null || b.getKodeBarang().trim().isEmpty()) {
            throw new IllegalArgumentException("Kode barang wajib diisi");
        }
        if (b.getHarga() < 0) {
            throw new IllegalArgumentException("Harga tidak boleh negatif");
        }
        if (b.getStok() < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif");
        }
    }
}