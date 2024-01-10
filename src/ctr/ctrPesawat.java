/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import ent.entPesawat;
import ent.entPenumpang;
import java.util.ArrayList;
/**
 *
 * @author SATYA
 */
public class ctrPesawat {
    entPesawat o = new entPesawat();
    
    public void setIDPesawat(String pid_pesawat){
        o.setid_pesawat(pid_pesawat);
        o.caripesawat();
    }
    
    public ArrayList<String> getIDPesawat(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(o.getidpesawat());
        vLst.add(o.atnama_mskp);
        vLst.add(o.attujuan);
        vLst.add(o.attanggal_kbrngktn);
        vLst.add(o.atwaktu_kbrngktn);
        return vLst;
    }
    
    public void setDataPesawat(ArrayList<String> p){
        o.setid_pesawat(p.get(0));
        o.atnama_mskp=p.get(1);
        o.attujuan=p.get(2);
        o.attanggal_kbrngktn=p.get(3);
        o.atwaktu_kbrngktn=p.get(4);
       
    }
    
    public void simpanpesawat(){
        o.insertpesawat();
    }
    
    public void updatepesawat(){
        o.updatepesawat();
    }
    
    public void hapuspesawat(){
        o.deletepesawat();
    }
}
