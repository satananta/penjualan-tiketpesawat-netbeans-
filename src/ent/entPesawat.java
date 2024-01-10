/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import database.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author SATYA
 */
public class entPesawat {
    private String atid_pesawat = "";
    public String atnama_mskp = "";
    public String attujuan = "";
    public String attanggal_kbrngktn = "";
    public String atwaktu_kbrngktn = "";
    
    public void setid_pesawat(String pid_pesawat){
        this.atid_pesawat = pid_pesawat;
    }
    
    public String getidpesawat(){
        return this.atid_pesawat;
    }
    
    public void caripesawat(){
        String vSql =   "SELECT pesawat.id_pesawat, pesawat.nama_mskp, pesawat.tujuan, pesawat.tanggal_kbrngktn, pesawat.waktu_kbrngktn " +
                        "FROM pesawat " +
                        "WHERE pesawat.id_pesawat='"+ this.atid_pesawat +"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(vSql);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                this.atid_pesawat=rs.getString("id_pesawat");
                this.atnama_mskp=rs.getString("nama_mskp");
                this.attujuan=rs.getString("tujuan");
                this.attanggal_kbrngktn=rs.getString("tanggal_kbrngktn");  
                this.atwaktu_kbrngktn=rs.getString("waktu_kbrngktn");
            }else{
                this.atid_pesawat = "";
                this.atnama_mskp = "";
                this.attujuan = "";
                this.attanggal_kbrngktn = "";
                this.atwaktu_kbrngktn = "";
            }
                      
        } catch (SQLException e){
            System.out.println("error----->"+e.toString());
        } 
    }
    public void insertpesawat() {
       
        String vSql =   "INSERT INTO pesawat " +
                        "(pesawat.id_pesawat, pesawat.nama_mskp, pesawat.tujuan, pesawat.tanggal_kbrngktn, pesawat.waktu_kbrngktn) " +
                        "VALUES ('"+ this.atid_pesawat +"', '"+ this.atnama_mskp+"', '"+ this.attujuan +"', '"+ this.attanggal_kbrngktn +"', '"+ this.atwaktu_kbrngktn +"')";
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
    public void updatepesawat() {
        String vSql =   "UPDATE pesawat SET " +
                        "pesawat.id_pesawat='"+ this.atid_pesawat +"', pesawat.nama_mskp='"+ this.atnama_mskp +"', " +
                        "pesawat.tujuan='"+ this.attujuan +"', pesawat.tanggal_kbrngktn='"+ this.attanggal_kbrngktn +"', pesawat.waktu_kbrngktn='"+ this.atwaktu_kbrngktn +"' " +
                        "WHERE pesawat.id_pesawat='"+ this.atid_pesawat +"'";
        System.out.println(vSql);
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
    public void deletepesawat() {
        String vSql="DELETE FROM pesawat WHERE pesawat.id_pesawat='"+this.atid_pesawat+"'";
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
        entPesawat o = new entPesawat();
//        o.setid_pesawat("003");
//        o.delete();
        
//        o.setid_pesawat("001");
//        o.atnama_mskp="garuda";
//        o.attujuan="bandung";
//        o.attanggal_kbrngktn="12122002";
//        o.atwaktu_kbrngktn="1400";
//        o.update();

//        o.setid_pesawat("002");
//        o.atnama_mskp="garuda";
//        o.attujuan="bandung";
//        o.attanggal_kbrngktn="12122002";
//        o.atwaktu_kbrngktn="1400";
//        o.insertpesawat();

//        o.setid_pesawat("002");
//        o.caripesawat();
//        System.out.println("ID Pesawat : "+o.getid_pesawat());
//        System.out.println("Nama maskapai : "+o.atnama_mskp);
//        System.out.println("Tujuan : "+o.attujuan);
//        System.out.println("Tanggal Keberangkatan :"+o.attanggal_kbrngktn);
//        System.out.println("Waktu Keberangkatan :"+o.atwaktu_kbrngktn);
    }
}
