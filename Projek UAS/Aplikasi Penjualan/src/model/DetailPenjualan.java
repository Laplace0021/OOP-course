package model;

public class DetailPenjualan {
    private int idDetail;
    private int idPenjualan;
    private String kodeBarang;
    private String namaBarang;
    private double harga;
    private int qty;
    private double subtotal;

    public DetailPenjualan(){
        
    }

    public DetailPenjualan(String kodeBarang, String namaBarang, double harga, int qty) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.harga = harga;
        this.qty = qty;
        this.subtotal = harga * qty;
    }
    public int getIdDetail(){return idDetail;}
    public void setIdDetail(int idDetail){this.idDetail=idDetail;}

    public int getIdPenjualan(){return idPenjualan;}
    public void setIdPenjualan(int idPenjualan){this.idPenjualan=idPenjualan;}

    public String getKodeBarang(){return kodeBarang;}
    public void setKodeBarang(String kodeBarang){this.kodeBarang=kodeBarang;}

    public String getNamaBarang(){return namaBarang;}
    public void setNamaBarang(String namaBarang){this.namaBarang=namaBarang;}

    public double getHarga(){return harga;}
    public void setHarga(double harga){this.harga=harga;}

    public int getQty(){return qty;}
    public void setQty(int qty){this.qty=qty;this.subtotal=this.harga*qty;}

    public double getSubtotal(){return subtotal;}
    public void setSubtotal(double subtotal){this.subtotal=subtotal;}
}
