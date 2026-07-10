public class Arithmetic1 {
    public static void main(String[] args) {
        try {
            
            int hasil = 10/0;
            System.out.println(hasil);
        } catch (Exception e) {
            System.out.println("Tidak bisa membagi dengan 0");
        }
        finally{
            System.out.println("Program selesai");
        }
        
    }
}