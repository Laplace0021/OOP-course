class Mahasiswa {
    //Atribute Property
    //"private " artinya hanya bisa diakses oleh class ini saja
    private String nama;
    private int umur;

    //Constructor
    //constructor akan otomatis dipanggil saat objek baru dibuat dengan "new"
    //parameter didalam constructor digunakan untuk mengisi nilai awal atribut
    Mahasiswa(String nama, int umur){
        //kata kunci "this" diapakai untuk membedakan
        //antara atribut class(this.nama) dengan parameter method nama
        this.nama = nama;
        this.umur = umur;
    }
    //getter
    //getter dipakai untuk membaca/memanggil nilai atribut
    public String getNama(){
        return this.nama;
    }
    public int getUmur(){
        return this.umur;
    }
    //setter
    //setter dipakai untuk mengubah nilai atribut dari luar class
    public void setNama(String nama){
        //gunakan this agar jelas bahwa yang dikiri adalah atribut yang dikanan parameter
        this.nama = nama;
    }
    public void setUmur(int umur){
        //bisa tambahkan logika sederhana (misalnya validasi)
        if (umur>0){
            this.umur = umur;
        }
    }

    //method tambahan untuk menampilkan info mahasiswa
    public void tampilkanInfo(){
        System.out.println("Nama :"+this.nama);
        System.out.println("Umur :"+this.umur +" tahun");
    }
}
//class utama yang memiliki method main (titik awal program java)
public class DemoMahasiswa {
    public static void main(String[] args) {
        //membuat objek
        //memanggil contructor mahasiswa (String nama, int umur)
        Mahasiswa mhs1 = new Mahasiswa("Budi",20 );
        Mahasiswa mhs2 = new Mahasiswa("Siti",19 );

        //menggunakan getter untuk membaca nilai
        System.out.println("Data awal: ");
        System.out.println("Mahasiswa 1: "+mhs1.getNama()+", "+mhs1.getUmur()+" tahun");
        System.out.println("Mahasiswa 2: "+mhs2.getNama()+", "+mhs2.getUmur()+" tahun");
        
        //menggunakan setter untuk mengubah nilai
        mhs1.setNama("Budi Santoso");
        mhs1.setUmur(21);

        mhs1.setNama("Siti Rahmawati");
        mhs1.setUmur(20);

        //memanggil method lain di class
        System.out.println("\n Setelah diubah (menggunakan setter):");
        mhs1.tampilkanInfo();
        mhs2.tampilkanInfo();
    }
}