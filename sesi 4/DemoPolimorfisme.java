//Super Class
class produk {
    protected String nama;
    protected int harga;

    public produk(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public String tampilInfo() {
        return "[UMUM]    " + nama + " | Harga: " + harga;
    }
}

// Sub Class 1
class produkFisik extends produk {
    private double beratKg;

    public produkFisik(String nama, int harga, double beratKg) {
        super(nama, harga);
        this.beratKg = beratKg;
    }

    @Override
    public String tampilInfo() {
        return "[FISIK]    " + nama + " | Harga: " + harga + " | Berat: " + beratKg + " KG";
    }
}

// Sub Class 2
class produkDigital extends produk {
    private String masaAktif;

    public produkDigital(String nama, int harga, String masaAktif) {
        super(nama, harga);
        this.masaAktif = masaAktif;
    }

    @Override
    public String tampilInfo() {
        return "[DIGITAL]    " + nama + " | Harga: " + harga + " | Masa Aktif: " + masaAktif;
    }
}

// Class Kasir (Overloading)
class kasir {
    //Overload 1: tanpa diskon
    public int hitungBayar(int harga, int qty){
        return harga * qty;
    }
    //Overload 2: dengan diskon
    public int hitungBayar(int harga, int qty, double diskonPersen){
        int total=harga*qty;
        return (int) (total-(total*diskonPersen/100));
    }
}

//Program Utama
public class DemoPolimorfisme{
 public static void main(String[] args) {
    System.out.println("=== DEMO OVERRIDING ===");
    System.out.println("Memanggil tampilkanInfo() dari masing masing objek: \n");
    
    produk p1 = new produk("kaos Polos", 85000);
    produkFisik p2 = new produkFisik("Sepatu lari", 350000, 0.8);
    produkDigital p3 = new produkDigital("Microsoft 365", 600000, "1 Tahun");

    System.out.println(p1.tampilInfo());
    System.out.println(p2.tampilInfo());
    System.out.println(p3.tampilInfo());

    System.out.println("\n === DEMO OVERLOADING ===");
    System.out.println("Memanggil hitungBayar() dengan argumen yang berbeda:\n");
    
    kasir kasir = new kasir();

    int total1 = kasir.hitungBayar(50000, 2);
    int total2 = kasir.hitungBayar(50000, 2, 15);

    System.out.println("hitungBayar(50000, 2)       = "+ total1);
    System.out.println("hitungBayar(50000, 2,15)    = "+ total2);
 }   
}