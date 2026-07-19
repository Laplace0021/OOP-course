package service;

import dao.MovieDAO;
import dao.TicketDAO;
import entity.Movie;

import java.sql.SQLException;
import java.util.List;

public class CinemaService {
    private final MovieDAO movieDAO = new MovieDAO();
    private final TicketDAO ticketDAO = new TicketDAO();

    public void addMovie(String title, String genre, int duration, int seats) {
        try {
            movieDAO.addMovie(title, genre, duration, seats);
            System.out.println("Film berhasil ditambahkan.");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan film: " + e.getMessage());
        }
    }

    public void showAllMovies() {
        try {
            List<Movie> movies = movieDAO.getAllMovies();
            if (movies.isEmpty()) {
                System.out.println("Belum ada film.");
                return;
            }
            for (Movie m : movies) {
                m.displayInfo();
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data film: " + e.getMessage());
        }
    }

    public void bookTicket(int movieId, String customerName, String phone, String seatNumber) {
        try {
            Movie movie = movieDAO.getMovieById(movieId);
            if (movie == null) {
                System.out.println("Film dengan ID tersebut tidak ditemukan.");
                return;
            }

            int remaining = movieDAO.getRemainingSeats(movieId);
            if (remaining <= 0) {
                System.out.println("Maaf, kursi untuk film ini sudah penuh.");
                return;
            }

            ticketDAO.bookTicket(movieId, customerName, phone, seatNumber);
            System.out.println("Tiket berhasil dipesan untuk " + customerName + " di kursi " + seatNumber);

        } catch (SQLException e) {
            System.out.println("Gagal memesan tiket: " + e.getMessage());
        }
    }

    public void cancelTicket(int ticketId) {
        try {
            ticketDAO.cancelTicket(ticketId);
            System.out.println("Tiket berhasil dibatalkan.");
        } catch (SQLException e) {
            System.out.println("Gagal membatalkan tiket: " + e.getMessage());
        }
    }

    public void showAllTickets() {
        try {
            var tickets = ticketDAO.getAllTickets();
            if (tickets.isEmpty()) {
                System.out.println("Belum ada riwayat pemesanan.");
                return;
            }
            for (var t : tickets) {
                System.out.println("ID:" + t.getId() + " | Movie:" + t.getMovieId() +
                        " | Customer:" + t.getCustomerId() + " | Kursi:" + t.getSeatNumber() +
                        " | Status:" + t.getStatus());
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil riwayat: " + e.getMessage());
        }
    }

    public void showActiveTickets() {
        try {
            ticketDAO.printActiveTickets();
        } catch (SQLException e) {
            System.out.println("Gagal mengambil tiket aktif: " + e.getMessage());
        }
    }
}