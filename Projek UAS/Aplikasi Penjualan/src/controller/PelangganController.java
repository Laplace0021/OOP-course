package controller;

import dao.PelangganDAO;
import model.Pelanggan;

import java.sql.SQLException;
import java.util.List;

public class PelangganController {

    private final PelangganDAO pelangganDAO = new PelangganDAO();

    public List<Pelanggan> getAllPelanggan() throws SQLException {
        return pelangganDAO.getAll();
    }

    public List<Pelanggan> cariPelanggan(String keyword) throws SQLException {
        return pelangganDAO.cari(keyword);
    }

    public boolean tambahPelanggan(Pelanggan p) throws SQLException {
        if (p.getNamaPelanggan() == null || p.getNamaPelanggan().trim().isEmpty()) {
            throw new IllegalArgumentException("Nama pelanggan wajib diisi");
        }
        return pelangganDAO.tambah(p);
    }

    public boolean ubahPelanggan(Pelanggan p) throws SQLException {
        return pelangganDAO.ubah(p);
    }

    public boolean hapusPelanggan(int idPelanggan) throws SQLException {
        return pelangganDAO.hapus(idPelanggan);
    }
}