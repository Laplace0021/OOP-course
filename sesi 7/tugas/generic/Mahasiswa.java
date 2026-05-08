
public class Mahasiswa <ID, NAME, CLAS>{
    protected ID NIM;
    protected NAME Nama;
    protected CLAS Clas;


    public void setNim(ID NIM){
        this.NIM=NIM;
    }

    public void setnama(NAME Nama){
        this.Nama = Nama;
    }

    public void setClas(CLAS Clas){
        this.Clas = Clas;
    }

    public ID getNim(){
        return NIM;
    }

    public NAME getName(){
        return Nama;
    }

    public CLAS getClas(){
        return Clas;
    }
}
