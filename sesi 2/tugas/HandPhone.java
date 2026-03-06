package tugas;

public class HandPhone {
    String Jenis_hp;
    int tahun_pembuatan;

    public void setDataHP(String Jenis_hp, int tahun_pembuatan){
        this.Jenis_hp = Jenis_hp;
        this.tahun_pembuatan= tahun_pembuatan;
    }

    public String getJenisHP(){
        return this.Jenis_hp;
    }

    public int getTahunPembuatan(){
        return this.tahun_pembuatan;
    }

    public static void main(String[] args) {
        HandPhone hp = new HandPhone();
        hp.setDataHP( "Realme 3", 2019);
        System.out.println("Jenis HP: "+hp.getJenisHP());
        System.out.println("Tahun Pembuatan: "+hp.getTahunPembuatan());
    }
}
