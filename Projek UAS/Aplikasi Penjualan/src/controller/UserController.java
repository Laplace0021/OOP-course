package controller;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {

    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) throws SQLException {
        if (username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Username dan password wajib diisi");
        }
        return userDAO.login(username, password);
    }

    public List<User> getAllUser() throws SQLException {
        return userDAO.getAll();
    }

    public List<User> cariUser(String keyword) throws SQLException {
        return userDAO.cari(keyword);
    }

    public boolean tambahUser(User user) throws SQLException {
        return userDAO.tambah(user);
    }

    public boolean ubahUser(User user) throws SQLException {
        return userDAO.ubah(user);
    }

    public boolean hapusUser(int idUser) throws SQLException {
        return userDAO.hapus(idUser);
    }
}