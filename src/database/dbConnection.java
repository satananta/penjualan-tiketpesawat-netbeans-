/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author SATYA
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class dbConnection {
    private Connection conn;

    public Connection koneksiDB() {
        if (this.conn == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String vDriver = "jdbc:mysql://localhost/penjualan_pesawat";
                this.conn = DriverManager.getConnection(vDriver, "root", "");
            } catch (ClassNotFoundException e) {
                System.out.println(e);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        }
        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
    }
}
