import java.util.ArrayDeque;
public class App {
    public static void main(String[] args) {
        Barang Sepatu = new Barang("Sepatu Converse", 300000);
        Barang Kemeja = new Barang("Kemeja Flanel", 200000);
        Barang Topi = new Barang("Topi Polos", 50000);

        User budi = new User("Budi");
        User andi = new User("Andi");

        budi.addBelanjaan(Topi);
        budi.addBelanjaan(Topi);
        budi.addBelanjaan(Kemeja);
        budi.addBelanjaan(Sepatu);
        budi.addBelanjaan(Kemeja);

        andi.addBelanjaan(Topi);
        andi.addBelanjaan(Sepatu);
        andi.addBelanjaan(Kemeja);
        andi.addBelanjaan(Kemeja);

        ArrayDeque<User> antrian = new ArrayDeque<>();
        antrian.addLast(budi);
        antrian.addLast(andi);

        while (!antrian.isEmpty()) {
            User palingDepan = antrian.pollFirst();
            System.out.println("Kasir melayani: "+palingDepan.getNama());
            palingDepan.checkOut();
        }

        System.out.println("Antrian Kosong");
    }
}
