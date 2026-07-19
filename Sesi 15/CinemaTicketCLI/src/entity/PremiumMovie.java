package entity;

public class PremiumMovie extends Movie {
    private double extraPrice;
    public PremiumMovie(int id,String title,String genre,int duration, int availableSeats, double extraPrice){
        super(id, title, genre, duration, availableSeats);
        this.extraPrice = extraPrice;
    }

    public double getExtraPrice(){ return extraPrice;}
    public void setExtraPrice(double extraPrice){this.extraPrice=extraPrice;}

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Kategori: PREMIUM");
        System.out.println("Biaya tambahan: Rp"+extraPrice);
    }
}
