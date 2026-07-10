public class ThrowSederhana {
    public static void main(String[] args) throws Exception {
        int umur = 15;
        if (umur<17) {
            throw new Exception("Umur belum cukup");
        }
    }
}
