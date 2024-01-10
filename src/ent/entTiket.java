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
public class entTiket {
    private String atid_tiket = "";
    public String atharga = "";
    public String atkelas = "";
    public String atstatus = "";
    
    public void setid_tiket(String pid_tiket){
        this.atid_tiket = pid_tiket;
    }
    
    public String getidtiket(){
        return this.atid_tiket;
    }
    
    public void caritiket(){
        String vSql =   "SELECT tiket.id_tiket, tiket.harga, tiket.kelas, tiket.status " +
                        "FROM tiket " +
                        "WHERE tiket.id_tiket='"+ this.atid_tiket +"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(vSql);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                this.atid_tiket=rs.getString("id_tiket");
                this.atharga=rs.getString("harga");
                this.atkelas=rs.getString("kelas");
                this.atstatus=rs.getString("status");
            }else{
                this.atid_tiket = "";
                this.atharga = "";
                this.atkelas = "";
                this.atstatus = "";
            }
                      
        } catch (SQLException e){
            System.out.println("error----->"+e.toString());
        } 
    }
    public void inserttiket() {
       
        String vSql =   "INSERT INTO tiket " +
                        "(tiket.id_tiket, tiket.harga, tiket.kelas, tiket.status) " +
                        "VALUES ('"+ this.atid_tiket +"', '"+ this.atharga+"', '"+ this.atkelas +"', '"+ this.atstatus +"')";
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
    public void updatetiket() {
        String vSql =   "UPDATE tiket SET " +
                        "tiket.id_tiket='"+ this.atid_tiket +"', tiket.harga='"+ this.atharga +"', " +
                        "tiket.kelas='"+ this.atkelas +"', tiket.status='"+ this.atstatus +"' " +
                        "WHERE tiket.id_tiket='"+ this.atid_tiket +"'";
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
    public void deletetiket() {
        String vSql="DELETE FROM tiket WHERE tiket.id_tiket='"+this.atid_tiket+"'";
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
        entTiket o = new entTiket();
//        o.setid_tiket("003");
//        o.delete();
        
//        o.setid_tiket("001");
//        o.atharga="121111111";
//        o.atkelas="business";
//        o.atstatus="dibayar";
//        o.insert();
//        o.update();

        o.setid_tiket("001");
        o.atharga="121111111";
        o.atkelas="business";
        o.atstatus="dibayar";
        o.inserttiket();

//        o.setid_tiket("002");
//        o.caritiket();
//        System.out.println("ID Tiket : "+o.getid_tiket());
//        System.out.println("Harga : "+o.atharga);
//        System.out.println("Kelas : "+o.atkelas);
//        System.out.println("Status :"+o.atstatus);
    }
}
