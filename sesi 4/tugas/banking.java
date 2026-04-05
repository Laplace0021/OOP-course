class Bank {
    void TransferUang(int jumlah, String rekeningTujuan){
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));
    }
    void TransferUang(int jumlah, String rekeningTujuan, String bankTujuan){
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));
    }
    void TransferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita){
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Berita:             "+berita);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));        
    }

    void sukuBunga(){
        System.out.println("Suku Bunga Strandar Adalah 3%");
    }
}

class BankBNI extends Bank{
    @Override
    void sukuBunga(){
        System.out.println("Suku Bunga dari BNI adalah : 4%");
    }

    @Override
    void TransferUang(int jumlah, String rekeningTujuan){
        String bankTujuan = "BNI";
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));
    }
    @Override
    void TransferUang(int jumlah, String rekeningTujuan, String berita){
        String bankTujuan = "BNI";
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Berita:             "+berita);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));        
    }
}

class BankBCA extends Bank{
@Override
    void sukuBunga(){
        System.out.println("Suku Bunga dari BCA adalah : 4.5%");
    }

    @Override
    void TransferUang(int jumlah, String rekeningTujuan){
        String bankTujuan = "BCA";
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));
    }
    @Override
    void TransferUang(int jumlah, String rekeningTujuan, String berita){
        String bankTujuan = "BCA";
        System.out.println("=".repeat(35));
        System.out.println("No. Rek Penerima:   "+rekeningTujuan);
        System.out.println("Bank Tujuan:        "+bankTujuan);
        System.out.println("Berita:             "+berita);
        System.out.println("Nominal Transfer:   "+jumlah);
        System.out.println("=".repeat(35));        
    }    
}

public class banking{
    public static void main(String[] args) {
        Bank bank = new Bank();
        BankBNI bankBNI = new BankBNI();
        BankBCA bankBCA = new BankBCA();

        bank.TransferUang(1000000, "1850004902");
        bank.TransferUang(4000000, "1850004902", "BCA");
        bank.TransferUang(5000000, "1850004902", "BNI", "Transfer Bulanan");
        bank.sukuBunga();

        bankBNI.TransferUang(4000000, "1850004902");
        bankBNI.TransferUang(5000000, "1850004902","Transfer Bulanan");
        bankBNI.sukuBunga();
        
        bankBCA.TransferUang(2000000, "1850004902");
        bankBCA.TransferUang(7000000, "1850004902","Transfer Bulanan");
        bankBCA.sukuBunga();        
    }
}