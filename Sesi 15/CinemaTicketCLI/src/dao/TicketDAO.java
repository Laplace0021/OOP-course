package dao;

import database.DatabaseConnection;
import entity.Ticket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    private int addCustomer(Connection conn, String name, String phone) throws SQLException {
        String sql = "INSERT INTO customers (customer_name, phone_number) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }

    public void bookTicket(int movieId, String customerName, String phone, String seatNumber) throws SQLException {
        try (Connection conn = DatabaseConnection.getConnection()) {

            int customerId = addCustomer(conn, customerName, phone);
            if (customerId == -1) {
                throw new SQLException("Gagal membuat data pelanggan.");
            }

            String sql = "INSERT INTO tickets (movie_id, customer_id, booking_date, seat_number, status) " +
                         "VALUES (?, ?, CURDATE(), ?, 'ACTIVE')";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, movieId);
                stmt.setInt(2, customerId);
                stmt.setString(3, seatNumber);
                stmt.executeUpdate();
            }
        }
    }

    public void cancelTicket(int ticketId) throws SQLException {
        String sql = "UPDATE tickets SET status = 'CANCELLED' WHERE id = ? AND status = 'ACTIVE'";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ticketId);
            int rows = stmt.executeUpdate();

            if (rows == 0) {
                throw new SQLException("Tiket tidak ditemukan atau sudah dibatalkan.");
            }
        }
    }

    public List<Ticket> getAllTickets() throws SQLException {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM tickets";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tickets.add(new Ticket(
                        rs.getInt("id"),
                        rs.getInt("movie_id"),
                        rs.getInt("customer_id"),
                        rs.getDate("booking_date"),
                        rs.getString("seat_number"),
                        rs.getString("status")
                ));
            }
        }
        return tickets;
    }

    public void printActiveTickets() throws SQLException {
        String sql = "SELECT * FROM active_ticket_view";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Ticket ID  : " + rs.getInt("ticket_id"));
                System.out.println("Film       : " + rs.getString("movie_title"));
                System.out.println("Pelanggan  : " + rs.getString("customer_name"));
                System.out.println("Kursi      : " + rs.getString("seat_number"));
                System.out.println("Tanggal    : " + rs.getDate("booking_date"));
                System.out.println("-----------------------------");
            }
        }
    }
}