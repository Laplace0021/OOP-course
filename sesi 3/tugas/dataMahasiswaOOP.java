import java.util.Scanner;       //import scanner agar bisa menerima input
import java.util.ArrayList;     //import arraylist agar data objek tersimpan

//Class Mahasiswa
class Mahasiswa{
    protected String nim;
    protected String nama;

    public Mahasiswa(String nim, String nama){
        // error handling jika user memasukan huruf kedalam String NIM
        if (!nim.matches("[0-9]+")){       
            throw new IllegalArgumentException("NIM tidak valid! NIM harus berupa angka!");
        }
        this.nim = nim;

        if (nama==null || nama.trim().isEmpty()) throw new IllegalArgumentException("Nama tidak boleh kosong!"); //error handling jika nama kosong
        // mengubah huruf pertama menjdi kapital
        if (nama.length()==1){
            this.nama=nama.toUpperCase();
        } else {
            this.nama = nama.substring(0,1).toUpperCase()+nama.substring(1).toLowerCase();
        }
    }
    public String getNama(){
        return nama;
    }

    public void getData(){
        System.out.println("NIM : "+nim);
        System.out.println("Nama: "+nama);
    }
}
//inheritance: subclass MahasiswaOOP dari superclass Mahasiswa
class MahasiswaOOP extends Mahasiswa{
    private final int nilai;

    MahasiswaOOP(String nim, String nama, int nilai){
        super(nim,nama);
        // error handling untuk nilai diluar 0-100
        if (nilai<0 || nilai >100){
            throw new IllegalArgumentException("Input nilai harus berada di antara 0 hingga 100");
        }
        this.nilai = nilai;
    }
    public int getNilai(){
        return nilai;
    }
    public String getGrade(){
        if (nilai>=80) {
            return "A";
        } else if (nilai>=70) {
            return "B";
        } else if (nilai>=60) {
            return "C";
        } else if (nilai>=50) {
            return "D";
        } else{ 
            return "E";
        }
    }
    @Override
    public void getData(){
        System.out.println("NIM   : "+nim);
        System.out.println("Nama  : "+nama);
        System.out.println("Nilai : "+nilai);
        System.out.println("Grade : "+getGrade());
        System.out.println("=".repeat(50));
    }
}
public class dataMahasiswaOOP{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    //inisialisasi scanner    
        ArrayList<MahasiswaOOP> mhsOOP = new ArrayList<>();     //inisialisasi arraylist
        // insialisasi variable-variable yang diguanakn di main
        int lulus = 0;
        int tidakLulus=0;
        String namaLulus="";
        String namaTidakLulus="";
        int gradeA =0,gradeB=0,gradeC=0,gradeD=0,gradeE=0;
        String namaGradeA="",namaGradeB="",namaGradeC="",namaGradeD="",namaGradeE="";
        String nilaitertulis="";
        double jumlahNilai=0;
        boolean lanjut = true;
        System.out.println("=== Input Mahasiswa ===");
        // menerima banyak input data
        while(lanjut){  
            try {
                System.out.print("Masukan NIM: ");
                String nim = sc.nextLine();
                System.out.print("Masukan Nama: ");
                String nama = sc.nextLine();
                System.out.print("Masukan Nilai OOP: ");
                // menggunakan parseInt agar bisa menggunakan nextLine(), 
                // menyelesaikan masalah buffer dari penggunaan nextInt()
                int nilai = Integer.parseInt(sc.nextLine());       
                mhsOOP.add(new MahasiswaOOP(nim,nama,nilai));
                System.out.print("Masukan data lagi?(y/n) ");
                if(sc.nextLine().equalsIgnoreCase("n")) lanjut = false;

            //error handling
            } catch (NumberFormatException e){
                System.out.println("ERROR: Nilai harus berupa angka yang valid!");
            } catch (IllegalArgumentException e){
                System.out.println("ERROR: "+e.getMessage() + "\n");
            }
        }
        System.out.println("\n=== Data Mahasiswa ===");
        for (MahasiswaOOP mhs: mhsOOP){
            mhs.getData();
            String grade=mhs.getGrade();

            // menentukan jumlah mahasiswa lulus/tidak beserta namanya
            //menentukan jumlah mahasiswa dengan grade x beserta namanya
            switch (grade) {
                case "A":
                    lulus++;
                    if (!namaLulus.isEmpty()) namaLulus+=", ";   
                    namaLulus+=mhs.getNama();
                    gradeA++;
                    if(!namaGradeA.isEmpty()) namaGradeA+=", ";
                    namaGradeA+=mhs.getNama();
                    break;
                 case "B":
                    lulus++;
                    if (!namaLulus.isEmpty()) namaLulus+=", ";
                    namaLulus+=mhs.getNama();                        
                    gradeB++;
                    if(!namaGradeB.isEmpty()) namaGradeB+=", ";
                    namaGradeB+=mhs.getNama();
                    break;
                case "C":
                    lulus++;
                    if (!namaLulus.isEmpty()) namaLulus+=", ";
                    namaLulus+=mhs.getNama();                        
                    gradeC++;
                    if (!namaGradeC.isEmpty()) namaGradeC+=", ";
                    namaGradeC+=mhs.getNama();
                    break;
                case "D":
                    tidakLulus++;
                    if (!namaTidakLulus.isEmpty()) namaTidakLulus+=", ";
                    namaTidakLulus+=mhs.getNama();
                    gradeD++;
                    if (!namaGradeD.isEmpty()) namaGradeD+=", ";
                    namaGradeD+=mhs.getNama();
                    break;
                case "E":
                    tidakLulus++;
                    if (!namaTidakLulus.isEmpty()) namaTidakLulus+=", ";
                    namaTidakLulus+=mhs.getNama();                        
                    gradeE++;
                    if (!namaGradeE.isEmpty()) namaGradeE+=", ";
                    namaGradeE+=mhs.getNama();
                    break;
                }
            
            if (!nilaitertulis.isEmpty()) nilaitertulis+=" + ";
            nilaitertulis+= mhs.getNilai();
            jumlahNilai+=mhs.getNilai();
        }
        System.out.println("Jumlah Mahasiswa : "+mhsOOP.size());
        System.out.println("Jumlah Mahasiswa yang Lulus : "+lulus+" yaitu "+ namaLulus);
        System.out.println("Jumlah Mahasiswa yang Tidak Lulus : "+tidakLulus+ " yaitu "+ namaTidakLulus);
        if (gradeA!=0)System.out.println("Jumlah Mahasiswa dengan Nilai A : "+gradeA+" yaitu "+namaGradeA);
        if (gradeB!=0)System.out.println("Jumlah Mahasiswa dengan Nilai B : "+gradeB+" yaitu "+namaGradeB);
        if (gradeC!=0)System.out.println("Jumlah Mahasiswa dengan Nilai C : "+gradeC+" yaitu "+namaGradeC);
        if (gradeD!=0)System.out.println("Jumlah Mahasiswa dengan Nilai D : "+gradeD+" yaitu "+namaGradeD);
        if (gradeE!=0)System.out.println("Jumlah Mahasiswa dengan Nilai E : "+gradeE+" yaitu "+namaGradeE);
        if (mhsOOP.size()>0)System.out.println("Rata-rata nilai mahasiswa adalah : ("+ nilaitertulis+") / "+ mhsOOP.size()+" = "+(jumlahNilai/mhsOOP.size()));
    }
}