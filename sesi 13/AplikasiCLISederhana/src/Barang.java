public class Barang {
    private String kode_barang;
    private String nama_barang;
    private int harga_barang;
    private int stok_barang;

    public Barang(String kode_barang, String nama_barang, int harga_barang, int stok_barang){
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.harga_barang = harga_barang;
        this.stok_barang = stok_barang;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }
    
    public int getHarga_barang() {
        return harga_barang;
    }
    
    public int getStok_barang() {
        return stok_barang;
    }
}
