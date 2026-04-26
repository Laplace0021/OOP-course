import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== SIMULASI DATA AKADEMIK ===");

        System.out.println("\n[INPUT DATA DOSEN]");
        System.out.print("Masukkan Nama Dosen: ");
        String namaDosen = input.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String alamatDosen = input.nextLine();
        teacher teacher = new teacher(namaDosen, alamatDosen);

        System.out.print("Berapa banyak mata kuliah yang diampu? ");
        int jmlMatkulDosen = input.nextInt();
        input.nextLine();

        for(int i=0; i<jmlMatkulDosen;i++){
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + ": ");
            String matkul =input.nextLine();
            if (teacher.addCourse(matkul)){
                System.out.println(" -> Mata kuliah ditambahkan.");
            } else{
                System.out.println(" -> Gagal: Mata kuliah sudah ada!");
            }
        }

        System.out.println("\n[INPUT DATA MAHASISWA]");
        System.out.print("Masukkan Nama Mahasiswa: ");
        String namaMhs = input.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String alamatMhs = input.nextLine();
        student student = new student(namaMhs, alamatMhs);

        System.out.print("Berapa banyak mata kuliah yang diambil? ");
        int jmlMatkulMhs = input.nextInt();
        input.nextLine();

        for (int i = 0; i < jmlMatkulMhs; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + ": ");
            String matkul = input.nextLine();
            System.out.print("Nilai untuk " + matkul + " (Angka): ");
            int nilai = input.nextInt();
            input.nextLine(); // Konsumsi newline
            student.addCourseGrade(matkul, nilai);
        }

        // --- OUTPUT HASIL SIMULASI ---
        System.out.println("\n==============================");
        System.out.println("HASIL DATA SISTEM");
        System.out.println("==============================");
        
        // Cetak Info Dosen
        System.out.println(teacher.toString());
        
        // Cetak Info Mahasiswa
        System.out.println("\n" + student.toString());
        student.printGrades();
        System.out.println("Rata-rata Nilai: " + student.getAverageGrade());

        input.close();
    }
}
