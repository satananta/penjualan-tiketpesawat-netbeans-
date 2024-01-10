/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import ent.entPenumpang;
import java.util.ArrayList;
/**
 *
 * @author SATYA
 */
public class ctrPenumpang {
    entPenumpang o = new entPenumpang();
    
    public void setIDPenumpang(String pid_penumpang){
        o.setid_penumpang(pid_penumpang);
        o.caripenumpang();
    }
    
    public ArrayList<String> getIDPenumpang(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(o.getidpenumpang());
        vLst.add(o.atnama);
        vLst.add(o.atalamat);
        vLst.add(o.atemail);
        vLst.add(o.atnotelp);
        return vLst;
    }
    
    public void setDataPenumpang(ArrayList<String> p){
        o.setid_penumpang(p.get(0));
        o.atnama=p.get(1);
        o.atalamat=p.get(2);
        o.atemail=p.get(3);
        o.atnotelp=p.get(4);
    }
    
    public void simpanpenumpang(){
        o.insertpenumpang();
    }
    
    public void updatepenumpang(){
        o.updatepenumpang();
    }
    
    public void hapusspenumpang(){
        o.deletepenumpang();
    }
}
