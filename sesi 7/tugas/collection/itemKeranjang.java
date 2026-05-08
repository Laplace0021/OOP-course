public class itemKeranjang {
    Barang barang;
    int qty;

    public itemKeranjang(Barang barang, int qty){
        this.barang=barang;
        this.qty=qty;
    }

    public void addQty(int jumlah) {
        this.qty += jumlah;
    }

    public void decreaseQty(int jumlah) {
        if (this.qty > 0) {
            this.qty -= jumlah;
        }
    }
    public int hitungSubtotal() {
        return this.barang.harga * this.qty; 
    }

    public Barang getBarang() {
        return this.barang;
    }

    public int getQty() {
        return this.qty;
    }
}
    