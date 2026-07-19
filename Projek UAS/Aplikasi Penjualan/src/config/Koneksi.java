package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/db_penjualan";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection connection;
    private Koneksi(){}

    public static Connection getConnection() throws SQLException{
        try{
            if (connection ==null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch(ClassNotFoundException e){
            throw new SQLException("Driver JDBC MySQL tidak ditemukan: "+e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi: "+ e.getMessage());
        }
    }
}
