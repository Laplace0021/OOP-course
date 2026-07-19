package entity;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private int duration;
    private int availableSeats;

    public Movie(int id, String title, String genre, int duration, int availableSeats){
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    
    public String getGenre(){return genre;}
    public void setGenre(String genre){this.genre=genre;}
    
    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(int availableSeats){this.availableSeats = availableSeats;}

    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Judul: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Durasi: " + duration + " menit");
        System.out.println("Kursi tersedia: " + availableSeats);
    }
}
