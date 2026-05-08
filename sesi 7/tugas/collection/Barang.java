public class Barang {
    String  nama;
    int harga;

    public Barang(String nama, int harga){
        this.nama=nama;
        this.harga=harga;
    }

    public String getNama(){
        return nama;
    }

    public int getHarga(){
        return harga;
    }

    public void setharga(int hargaBaru){
        if(hargaBaru>0){
            this.harga=hargaBaru;
        } else {
            System.out.println("Harga tidak valid");
        }
    }
}
