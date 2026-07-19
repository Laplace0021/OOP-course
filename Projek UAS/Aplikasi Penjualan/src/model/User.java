package model;

public class User {
    protected int idUser;
    protected String username;    
    protected String password;
    protected String namaLengkap;
    protected String role;

    public User() {
    }
    
    public User(int idUser, String username, String password, String namaLengkap, String role){
        this.idUser =idUser;
        this.username=username;
        this.password=password;
        this.namaLengkap=namaLengkap;
        this.role=role;
    }

    public int getIdUser(){return idUser;}
    public void setIdUser(int idUser){this.idUser=idUser;}

    public String getUsername(){return username;}
    public void setUsername(String username){this.username=username;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}

    public String getNamaLengkap(){return namaLengkap;}
    public void setNamaLengkap(String namaLengkap){this.namaLengkap=namaLengkap;}

    public String getRole(){return role;}
    public void setRole(String role){this.role=role;}

    public String displayMenu(){
        return "Menu kasir: Transaksi Penjualan, Laporan Penjualan";
    }

    public String toString(){
        return namaLengkap + " ("+role+")";
    }
}
