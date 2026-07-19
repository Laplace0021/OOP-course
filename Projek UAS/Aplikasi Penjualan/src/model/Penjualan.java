package model;

import java.sql.Timestamp;

public class Penjualan {
    private int idPenjualan;
    private Timestamp tanggal;
    private String namaPelanggan;
    private String username;
    private double total;

    public Penjualan(){
        
    }

    public Penjualan(int idPenjualan, Timestamp tanggal, String namaPelanggan, String username, double total){
        this.idPenjualan=idPenjualan;
        this.tanggal=tanggal;
        this.namaPelanggan=namaPelanggan;
        this.username=username;
        this.total=total;
    }

    public int getIdPenjualan(){return idPenjualan;}
    public void setIdPenjualan(int idPenjualan){this.idPenjualan=idPenjualan;}

    public Timestamp getTanggal(){return tanggal;}
    public void setTanggal(Timestamp tanggal){this.tanggal=tanggal;}

    public String getNamaPelanggan(){return namaPelanggan;}
    public void setNamaPelanggan(String namaPelanggan){this.namaPelanggan=namaPelanggan;}
    
    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public double getTotal(){return total;}
    public void setTotal(double total){this.total=total;}
}
