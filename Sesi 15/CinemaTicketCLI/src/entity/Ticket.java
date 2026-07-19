package entity;

import java.sql.Date;

public class Ticket {
    private int id;
    private int movieId;
    private int customerId;
    private Date bookingDate;
    private String seatNumber;
    private String status;

    public Ticket(int id, int movieId, int customerId, Date bookingDate, String seatNumber, String status) {
        this.id = id;
        this.movieId = movieId;
        this.customerId = customerId;
        this.bookingDate = bookingDate;
        this.seatNumber = seatNumber;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}