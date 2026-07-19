package model;

public class Admin extends User{

    public Admin() {
        super();
        this.role="admin";
    }

    public Admin(int idUser,String username, String password, String namaLengkap){
        super(idUser, username, password, namaLengkap,"admin");
    }
    @Override
    public String displayMenu(){
        return "Menu Admin: Data User, Data Barang, Data Pelanggan, "
        + "Transaksi Penjualan, Laporan Penjualan";
    }
}
