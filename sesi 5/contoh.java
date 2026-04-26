class Tabungan{
    private double saldo;

    void tambah(double jumlah){
        saldo+=jumlah;
    }

    void ambil(double jumlah){
        saldo-=jumlah;
    }

    void infoSaldo(){
        System.out.println("Saldo: "+saldo);
    }
}

public class contoh{
    public static void main(String[] args) {
        Tabungan yulhan= new Tabungan();
        // yulhan.saldo=-100000;
        yulhan.tambah(100000);
        yulhan.ambil(50000);
        yulhan.infoSaldo();
    }
}