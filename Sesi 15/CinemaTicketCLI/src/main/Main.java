package main;

import service.CinemaService;
import util.InputHelper;
import database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        CinemaService service = new CinemaService();
        boolean running = true;

        while (running) {
            System.out.println("\n===== CINEMA TICKET CLI =====");
            System.out.println("1. Tambah Film");
            System.out.println("2. Lihat Daftar Film");
            System.out.println("3. Pesan Tiket");
            System.out.println("4. Batalkan Tiket");
            System.out.println("5. Lihat Riwayat Pemesanan");
            System.out.println("6. Lihat Tiket Aktif");
            System.out.println("0. Keluar");

            int choice = InputHelper.readInt("Pilih menu: ");

            try {
                switch (choice) {
                    case 1 -> {
                        String title = InputHelper.readString("Judul film: ");
                        String genre = InputHelper.readString("Genre: ");
                        int duration = InputHelper.readInt("Durasi (menit): ");
                        int seats = InputHelper.readInt("Jumlah kursi: ");
                        service.addMovie(title, genre, duration, seats);
                    }
                    case 2 -> service.showAllMovies();
                    case 3 -> {
                        int movieId = InputHelper.readInt("ID Film: ");
                        String name = InputHelper.readString("Nama pelanggan: ");
                        String phone = InputHelper.readString("No. HP: ");
                        String seat = InputHelper.readString("Nomor kursi: ");
                        service.bookTicket(movieId, name, phone, seat);
                    }
                    case 4 -> {
                        int ticketId = InputHelper.readInt("ID Tiket yang dibatalkan: ");
                        service.cancelTicket(ticketId);
                    }
                    case 5 -> service.showAllTickets();
                    case 6 -> service.showActiveTickets();
                    case 0 -> {
                        running = false;
                        System.out.println("Terima kasih, sampai jumpa!");
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }

        DatabaseConnection.closeConnection();
    }
}