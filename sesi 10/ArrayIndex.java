public class ArrayIndex {
    public static void main(String[] args) {
        try {
            int [] angka = {1,2,3};
            System.out.println(angka[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index array tidak tersedia");
        } finally{
            System.out.println("program selesai");
        }
    }
}
