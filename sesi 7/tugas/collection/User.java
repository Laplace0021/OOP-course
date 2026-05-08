import java.util.ArrayList;

public class User {
    String nama;
    private ArrayList<itemKeranjang> keranjang= new ArrayList<>();

    public User(String nama){
        this.nama=nama;
    }
    public String getNama(){
        return nama;
    }

    public void addBelanjaan(Barang b){
        for (itemKeranjang item:keranjang){
            if(item.barang==b){
                item.qty+=1;
                System.out.println("Menambah jumlah "+b.nama+" menjadi "+item.qty);
                return;
            }
        }
        keranjang.add(new itemKeranjang(b, 1));
        System.out.println(this.nama+" memasukan "+b.nama+" kedalam keranjang");
    }

    public void checkOut(){
        int total=0;
        System.out.println("=====Rincian Belanja=====");
        for(itemKeranjang item:keranjang){
            Barang b = item.getBarang();
            int qty = item.getQty();
            int subtotal = item.hitungSubtotal();

            System.out.println(" - "+b.nama+ " (x"+qty +") = Rp"+subtotal);
            total+=subtotal;
        }
        System.out.println("TOTAL BAYAR: "+total+"\n");
    }
}
