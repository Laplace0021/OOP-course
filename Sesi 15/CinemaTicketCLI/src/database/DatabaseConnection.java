package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cinemaDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connection;
    public static Connection getConnection() throws SQLException{
        if (connection==null || connection.isClosed()) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new SQLException("Gagal koneksi ke database: "+e.getMessage());
            }
        }
        return connection;
    }
    public static void closeConnection(){
        try {
            if(connection!=null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi: "+e.getMessage());
        }
    }
}