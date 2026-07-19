package dao;

import database.DatabaseConnection;
import entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {
    public void addMovie(String title, String genre, int duration, int availableSeats) throws SQLException{
        String query = "{CALL add_movie(?,?,?,?)}";
        try (Connection con = DatabaseConnection.getConnection();
            CallableStatement cs =con.prepareCall(query)) {
            cs.setString(1, title);
            cs.setString(2, genre);
            cs.setInt(3, duration);
            cs.setInt(4, availableSeats);
            cs.execute();
        }
    }
    public List<Movie> getAllMovies() throws SQLException{
        List<Movie> movies = new ArrayList<>();
        String query = "SELECT * FROM movies";

        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Movie movie = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("genre"),
                        rs.getInt("duration"),
                        rs.getInt("available_seats")
                    );
                    movies.add(movie);
                }
            }
        return movies;
    }
    public Movie getMovieById(int id) throws SQLException{
        String query = "SELECT * FROM movies WHERE id = ?";
        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Movie(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("genre"),
                            rs.getInt("duration"),
                            rs.getInt("available_seats"));
                    }
                }
        }
        return null;
    }
    public int getRemainingSeats(int MovieId) throws SQLException{
        String query = "SELECT remaining_seats(?) AS sisa";

        try (Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, MovieId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("sisa");
                }
            } 
        }
        return 0; 
    }
}
