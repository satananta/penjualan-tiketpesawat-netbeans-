/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import ent.entTiket;
import java.util.ArrayList;
/**
 *
 * @author SATYA
 */
public class ctrTiket {
    entTiket o = new entTiket();
    
    public void setid_tiket(String pid_tiket){
        o.setid_tiket(pid_tiket);
        o.caritiket();
    }
    
    public ArrayList<String> getid_tiket(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(o.getidtiket());
        vLst.add(o.atharga);
        vLst.add(o.atkelas);
        vLst.add(o.atstatus);
        return vLst;
    }
    
    public void setdatatiket(ArrayList<String> p){
        o.setid_tiket(p.get(0));
        o.atharga=p.get(1);
        o.atkelas=p.get(2);
        o.atstatus=p.get(3);
    }
    
    public void save(){
        o.inserttiket();
    }
    
    public void edit(){
        o.updatetiket();
    }
    
    public void delete(){
        o.deletetiket();
    }

    public void setdatatiket(String[] vAPlg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}