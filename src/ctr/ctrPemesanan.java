/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctr;

import ent.entPemesanan;
import ent.entPenumpang;
import java.util.ArrayList;
/**
 *
 * @author SATYA
 */
public class ctrPemesanan {
    entPemesanan o = new entPemesanan();
    
    public void setid_pemesanan(String pid_pemesanan){
        o.setid_pemesanan(pid_pemesanan);
        o.cariPemesanan();
    }    
    
    public ArrayList<String> getIDPesanan(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(o.getid_pemesanan());
        vLst.add(o.atnomor_tiket);
        vLst.add(o.attanggal_pmsn);
        vLst.add(o.atnama_pmsn);
        vLst.add(o.atstatus);
        return vLst;
    }
    
    public void setDataPemesanan(ArrayList<String> p){
        o.setid_pemesanan(p.get(0));
        o.atnomor_tiket=p.get(1);
        o.attanggal_pmsn=p.get(2);
        o.atnama_pmsn=p.get(3);
        o.atstatus=p.get(4);
    }
    
    public void save(){
        o.insertpemesanan();
    }
    
    public void edit(){
        o.updatepemesanan();
    }
    
    public void delete(){
        o.deletepemesanan();
    }

    public void setDataPemesanan(String[] vAPlg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
