public class MultipleCatch {
    public static void main(String[] args) {
        try {
            // int angka = Integer.parseInt("abc");
            int hasil = 10/0;
            int data[]={1,2,3};
            System.out.println(data[10]);
        } catch (NumberFormatException e) {
            System.out.println("Format angka salah");
        } catch (ArithmeticException e){
            System.out.println("Tidak bisa dibagi nol");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Index array melebihi batas");
        } catch (Exception e ){
            System.out.println("Exeption umum");
        }
        System.out.println("Program selesai");

    }    
}
