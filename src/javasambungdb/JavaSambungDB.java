package javasambungdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JavaSambungDB {

    private String jdbcDriver = "com.mysql.jdbc.Driver";
    private String dbURL = "jdbc:mysql://localhost:3306/db_siswa_tkj";
    private String user = "root";
    private String pass = "";
    
    private Connection con; 
    private Statement stmt;

    public static void main(String[] args) {
        JavaSambungDB javasambungdb = new JavaSambungDB();
        javasambungdb.koneksi();
    }

    public void koneksi() {
        try {
            Class.forName(jdbcDriver);
            System.out.println("Driver berhasil dimuat");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver tidak ditemukan");
            return;
        }
         
        try {
            con = DriverManager.getConnection(dbURL, user, pass);
            System.out.println("Koneksi berhasil");
        } catch (SQLException ex) {
            System.out.println("Koneksi gagal: " + ex.getMessage());
        }
    }
}
