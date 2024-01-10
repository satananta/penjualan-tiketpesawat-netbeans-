/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

/**
 *
 * @author SATYA
 */
import database.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author SATYA
 */
public class entPemesanan {
    private String atid_pemesanan = "";
    public String atnomor_tiket = "";
    public String attanggal_pmsn = "";
    public String atnama_pmsn = "";
    public String atstatus = "";
    
     public void setid_pemesanan(String pid_pemesanan){
        this.atid_pemesanan = pid_pemesanan;
    }
    
    public String getid_pemesanan(){
        return this.atid_pemesanan;
    }
    
    public void cariPemesanan(){
        String vSql =   "SELECT pemesanan.id_pemesanan, pemesanan.nomor_tiket, pemesanan.tanggal_pmsn, pemesanan.nama_pmsn, pemesanan.status " +
                        "FROM pemesanan " +
                        "WHERE pemesanan.id_pemesanan='"+ this.atid_pemesanan +"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(vSql);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                this.atid_pemesanan=rs.getString("id_pemesanan");
                this.atnomor_tiket=rs.getString("nomor_tiket");
                this.attanggal_pmsn=rs.getString("tanggal_pmsn");
                this.atnama_pmsn=rs.getString("nama_pmsn");  
                this.atstatus=rs.getString("status");
            }else{
                this.atid_pemesanan = "";
                this.atnomor_tiket = "";
                this.attanggal_pmsn = "";
                this.atnama_pmsn = "";
                this.atstatus = "";
            }
                      
        } catch (SQLException e){
            System.out.println("error----->"+e.toString());
        } 
    }
    public void insertpemesanan() {
       
        String vSql =   "INSERT INTO pemesanan " +
                        "(pemesanan.id_pemesanan, pemesanan.nomor_tiket, pemesanan.tanggal_pmsn, pemesanan.nama_pmsn, pemesanan.status) " +
                        "VALUES ('"+ this.atid_pemesanan +"', '"+ this.atnomor_tiket +"', '"+ this.attanggal_pmsn +"', '"+ this.atnama_pmsn +"', '"+ this.atstatus +"')";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);           
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
    }
    public void updatepemesanan() {
        String vSql =   "UPDATE pemesanan SET " +
                        "pemesanan.id_pemesanan='"+ this.atid_pemesanan +"', pemesanan.nomor_tiket='"+ this.atnomor_tiket +"', " +
                        "pemesanan.tanggal_pmsn='"+ this.attanggal_pmsn +"', pemesanan.nama_pmsn='"+ this.atnama_pmsn +"', pemesanan.status='"+ this.atstatus +"' " +
                        "WHERE pemesanan.id_pemesanan='"+ this.atid_pemesanan +"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);                                                
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
   }
    public void deletepemesanan() {
        String vSql="DELETE FROM pemesanan WHERE pemesanan.id_pemesanan='"+this.atid_pemesanan+"'";
        dbConnection db = new dbConnection();
         Connection con = db.koneksiDB();
         PreparedStatement Stat = null;
         try{
             Stat = con.prepareStatement(vSql);                                                
             Stat.executeUpdate();
         } catch (SQLException ex) {
             System.out.println("Error -> "+ex.toString());
         }
    }

    public static void main(String[] args){
        entPemesanan o = new entPemesanan();
//        o.setid_pemesanan("003");
//        o.delete();
        
//        o.setid_pemesanan("001");
//        o.atnomor_tiket="002";
//        o.attanggal_pmsn="12022002";
//        o.atnama_pmsn="robby";
//        o.atstatus="ongoing";
//        o.update();

        o.setid_pemesanan("001");
        o.atnomor_tiket="002";
        o.attanggal_pmsn="12022002";
        o.atnama_pmsn="robby";
        o.atstatus="ongoing";
        o.insertpemesanan();

//        o.setid_pemesanan("002");
//        o.caripemesanan();
//        System.out.println("ID Pemesanan : "+o.getid_pemesanan());
//        System.out.println("Nomor Tiket : "+o.atnomor_tiket);
//        System.out.println("Tanggal Pemesanan : "+o.attanggal_pmsn);
//        System.out.println("Nama Pemesanan :"+o.atnama_pmsn);
//        System.out.println("Status :"+o.atstatus);
    }
}
