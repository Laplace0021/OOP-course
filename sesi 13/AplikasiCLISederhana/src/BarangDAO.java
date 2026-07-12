import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BarangDAO {
    public void showItem(){
        String query = "SELECT * FROM tbl_barang";

        try (Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){

            int nomor=0;
            while (rs.next()) {
                nomor++;
                 System.out.println("=".repeat(50));
                System.out.println("\t\t DAFTAR BARANG TOKO RETAIL");
                System.out.println("=".repeat(50));
                System.out.println("No          : " + nomor);
                System.out.println("Kode Barang : " + rs.getString("kode_barang"));
                System.out.println("Nama Barang : " + rs.getString("nama_barang"));
                System.out.println("Harga       : " + rs.getInt("harga_barang"));
                System.out.println("Stok        : " + rs.getInt("stok_barang"));
                System.out.println("------------------------------------------");
            }
            if(nomor==0){ 
                System.out.println("Data tidak ditemukan");
            } else {
                System.out.println("Total barang : "+nomor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertItem(Barang b){

        String query = "INSERT INTO tbl_barang VALUES (?,?,?,?)";
        
        try(Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, b.getKode_barang());
            ps.setString(2, b.getNama_barang());
            ps.setInt(3, b.getHarga_barang());
            ps.setInt(4, b.getStok_barang());

            if(ps.executeUpdate()>0){
                System.out.println(b.getNama_barang()+" telah ditambahkan");
            } else{
                System.out.println(b.getNama_barang()+" gagal ditambahkan");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void searchItem(String Keyword){
        String query = "SELECT * FROM tbl_barang WHERE nama_barang LIKE ?";

        try (Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1,"%"+Keyword+"%");
            try (ResultSet rs = ps.executeQuery()) {
                int nomor = 0;
                while(rs.next()){
                    nomor++;
                    System.out.println("=".repeat(50));
                    System.out.println("\t\t DAFTAR BARANG TOKO RETAIL");
                    System.out.println("=".repeat(50));
                    System.out.println("Nomor       : " + nomor);
                    System.out.println("Kode Barang : " + rs.getString("kode_barang"));
                    System.out.println("Nama Barang : " + rs.getString("nama_barang"));
                    System.out.println("Harga       : " + rs.getInt("harga_barang"));
                    System.out.println("Stok        : " + rs.getInt("stok_barang"));
                    System.out.println("------------------------------------");
                }
                if (nomor == 0) {
                    System.out.println("Data tidak ditemukan");
                } else {
                    System.out.println("Total Barang : " + nomor);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void updateItem(Barang b){
        String query = "UPDATE tbl_barang SET nama_barang=?, harga_barang=?, stok_barang=? WHERE kode_barang=?";
        try (Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, b.getNama_barang());
            ps.setInt(2, b.getHarga_barang());
            ps.setInt(3, b.getStok_barang());
            ps.setString(4,b.getKode_barang());

            if (ps.executeUpdate()>0) {
                System.out.println("Data telah diupdate");
            } else {
                System.out.println("Data gagal diupdate");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void deleteItem(String kode){
        String query = "DELETE FROM tbl_barang WHERE kode_barang=?";
        try (Connection con = Koneksi.getConnection();
            PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, kode);
            if (ps.executeUpdate() > 0) {
                System.out.println(kode+" telah dihapus!");
            } else {
                System.out.println("Data Tidak ditemukan");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
