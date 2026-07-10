public class ConcatMethods {
    public static void main(String[] args) {
        String namaDepan = "Yulhan";
        String middleName = " ";
        String namaBelakang = "Wahyudin";

        String namaLengkap = namaDepan.concat(middleName).concat(namaBelakang);
        System.out.println(namaLengkap);
    }
    
}
