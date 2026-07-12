import java.io.IOException;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BarangDAO dao = new BarangDAO();
        int choice;
        do {
            System.out.println("=".repeat(50));
            System.out.println("\t\tMENU TOKO RETAIL");
            System.out.println("=".repeat(50));
            System.out.println("1. Tampil Semua Data");
            System.out.println("2. Tambah Data");
            System.out.println("3. Cari Data");
            System.out.println("4. Ubah Data");
            System.out.println("5. Hapus Data");
            System.out.println("0. Keluar");
            System.out.print("Pilihan : ");
            choice =Integer.parseInt(sc.nextLine());
            
            switch (choice) {
                case 1:
                    dao.showItem();
                    break;

                case 2:
                    System.out.print("kode barang: ");
                    String kodeBarang = sc.nextLine();
                    System.out.print("Nama barang: ");
                    String namaBarang = sc.nextLine();
                    int hargaBarang=0;
                    int stokBarang=0;
                    try {
                        System.out.print("Harga barang: ");
                        hargaBarang = Integer.parseInt(sc.nextLine());
                        System.out.print("Stok barang: ");
                        stokBarang = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input harus berupa angka");
                    }
                    
                    Barang b = new Barang(kodeBarang, namaBarang, hargaBarang, stokBarang);
                    dao.insertItem(b);
                    break;

                case 3:
                    System.out.print("Nama barang yang dicari: ");
                    namaBarang = sc.nextLine();
                    dao.searchItem(namaBarang);
                    break;

                case 4:
                    System.out.print("Kode Barang yang mau diubah: ");
                    String kodeUbah = sc.nextLine();

                    System.out.print("Nama Barang baru: ");
                    String namaUbah = sc.nextLine();

                    int hargaUbah = 0;
                    int stokUbah = 0;

                    try {
                        System.out.print("Harga Barang baru: ");
                        hargaUbah = Integer.parseInt(sc.nextLine());
                        System.out.print("Stok Barang baru: ");
                        stokUbah = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        System.out.println("Input harus angka");
                    }

                    Barang bUbah = new Barang(kodeUbah, namaUbah, hargaUbah, stokUbah);
                    dao.updateItem(bUbah);
                    break;

                case 5:
                    System.out.print("Kode Barang yang akan dihapus: ");
                    String kodeHapus = sc.nextLine();
                    dao.deleteItem(kodeHapus);
                    break;

                default:
                    break;
            }
        } while (choice!=0);
        sc.close();
    }
}
