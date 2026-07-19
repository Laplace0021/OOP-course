package model;

public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private String kategori;
    private double harga;
    private int stok;

    public Barang(){
        
    }

    public Barang(String kodeBarang, String namaBarang, String kategori, double harga, int stok){
        this.kodeBarang=kodeBarang;
        this.namaBarang=namaBarang;
        this.kategori=kategori;
        this.harga=harga;
        this.stok=stok;
    }

    public String getKodeBarang(){return kodeBarang;}
    public void setKodeBarang(String kodeBarang){this.kodeBarang=kodeBarang;}

    public String getNamaBarang(){return namaBarang;}
    public void setNamaBarang(String namaBarang){this.namaBarang=namaBarang;}

    public String getKategori(){return kategori;}
    public void setKategori(String Kategori){this.kategori=kategori;}

    public double getHarga(){return harga;}
    public void setHarga(double harga){this.harga=harga;}

    public int getStok(){return stok;}
    public void setStok(int stok){this.stok =stok;}

    @Override
    public String toString() {
        return kodeBarang+ " - "+namaBarang;
    }
}
