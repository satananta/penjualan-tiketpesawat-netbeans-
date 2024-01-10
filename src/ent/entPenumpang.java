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
public class entPenumpang {
    private String atid_penumpang = "";
    public String atnama = "";
    public String atalamat = "";
    public String atemail = "";
    public String atnotelp = "";
    
    public void setid_penumpang(String pid_penumpang){
        this.atid_penumpang = pid_penumpang;
    }
    
    public String getidpenumpang(){
        return this.atid_penumpang;
    }
    
    public void caripenumpang(){
        String vSql =   "SELECT penumpang.id_penumpang, penumpang.nama, penumpang.alamat, penumpang.email, penumpang.notelp " +
                        "FROM penumpang " +
                        "WHERE penumpang.id_penumpang='"+ this.atid_penumpang +"'";
        dbConnection db = new dbConnection();
        Connection con = db.koneksiDB();
        PreparedStatement stat = null;
        try{
            stat = con.prepareStatement(vSql);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                this.atid_penumpang=rs.getString("id_penumpang");
                this.atnama=rs.getString("nama");
                this.atalamat=rs.getString("alamat");
                this.atemail=rs.getString("email");  
                this.atnotelp=rs.getString("notelp");
            }else{
                this.atid_penumpang = "";
                this.atnama = "";
                this.atalamat = "";
                this.atemail = "";
                this.atnotelp = "";
            }
                      
        } catch (SQLException e){
            System.out.println("error----->"+e.toString());
        } 
    }
    public void insertpenumpang() {
       
        String vSql =   "INSERT INTO penumpang " +
                        "(penumpang.id_penumpang, penumpang.nama, penumpang.alamat, penumpang.email, penumpang.notelp) " +
                        "VALUES ('"+ this.atid_penumpang +"', '"+ this.atnama+"', '"+ this.atalamat +"', '"+ this.atemail +"', '"+ this.atnotelp +"')";
        dbConnection db = new dbConnection();
        System.out.println(vSql);
        Connection con = db.koneksiDB();
        PreparedStatement Stat = null;
        try{
            Stat = con.prepareStatement(vSql);           
            Stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error -> "+ex.toString());
        }
    }
    public void updatepenumpang() {
        String vSql =   "UPDATE penumpang SET " +
                        "penumpang.id_penumpang='"+ this.atid_penumpang +"', penumpang.nama='"+ this.atnama +"', " +
                        "penumpang.alamat='"+ this.atalamat +"', penumpang.email='"+ this.atemail +"', penumpang.notelp='"+ this.atnotelp +"' " +
                        "WHERE penumpang.id_penumpang='"+ this.atid_penumpang +"'";
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
    public void deletepenumpang() {
        String vSql="DELETE FROM penumpang WHERE penumpang.id_penumpang='"+this.atid_penumpang+"'";
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
        entPenumpang o = new entPenumpang();
//        o.setid_penumpang("003");
//        o.delete();
        
//        o.setid_penumpang("001");
//        o.atnama="daniel";
//        o.atalamat="cihampelas";
//        o.atemail="danielgaming@yahoo";
//        o.atnotelp="8274878782748782";
//        o.update();

//        o.setid_penumpang("001");
//        o.atnama="daniel";
//        o.atalamat="cihampelas";
//        o.atemail="danielgaming@yahoo";
//        o.atnotelp="8274878782748782";
//        o.insertpenumpang();

//        o.setid_penumpang("002");
//        o.caripenumpang();
//        System.out.println("ID Penumpang : "+o.getid_penumpang());
//        System.out.println("Nama : "+o.atnama);
//        System.out.println("Alamat : "+o.atalamat);
//        System.out.println("Email :"+o.atemail);
//        System.out.println("Nomor Telepon :"+o.atnotelp);
    }
}
