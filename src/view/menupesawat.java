/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctr.ctrPesawat;
import database.dbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author SATYA
 */
public class menupesawat extends javax.swing.JPanel {
    ctrPesawat o = new ctrPesawat();
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    dbConnection db = new dbConnection(); Connection con = db.koneksiDB();

    /**
     * Creates new form menupesawat
     */
    public menupesawat() {
        initComponents();
        judul();
        tampilData("");
    }
    
    public void judul() {
        Object[] judul = {
            "ID Pesawat", "Nama Maskapai", "Tujuan", "Tanggal Keberangkatan", "Waktu Keberangkatan"
        };
        tabModel = new DefaultTableModel (null, judul);
        tabelpesawat.setModel(tabModel);
    }
    
    public void tampilData(String where) {
        try {
            st = con.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs=st.executeQuery("SELECT * FROM pesawat" + where);
            
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_pesawat"),
                    rs.getString("nama_mskp"),
                    rs.getString("tujuan"),
                    rs.getString("tanggal_kbrngktn"),
                    rs.getString("waktu_kbrngktn"),
                };
                tabModel.addRow(data);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void bukaForm(){
        txtIDPesawat.setText("");
        txtNmMaskapai.setText("");
        txtTujuan.setText("");
        txtTglKeberangkatan.setText("");
        txtWaktuKeberangkatan.setText("");
    }
    
    public void setIDPesawat(String pid_pesawat){
        o.setIDPesawat(pid_pesawat);
        txtIDPesawat.setText(o.getIDPesawat().get(0));
        txtNmMaskapai.setText(o.getIDPesawat().get(1));
        txtTujuan.setText(o.getIDPesawat().get(2));
        txtTglKeberangkatan.setText(o.getIDPesawat().get(3));
        txtWaktuKeberangkatan.setText(o.getIDPesawat().get(4));
    }
    
    private void setDataFromTable(int row) {
    // Mendapatkan data dari tabel untuk baris yang diklik
    String idPesawat = tabelpesawat.getValueAt(row, 0).toString();
    String nmMaskapai = tabelpesawat.getValueAt(row, 1).toString();
    String tujuan = tabelpesawat.getValueAt(row, 2).toString();
    String tglKeberangkatan = tabelpesawat.getValueAt(row, 3).toString();
    String waktuKeberangkatan = tabelpesawat.getValueAt(row, 4).toString();
    
    // Mengisi data pada panelAdd
    txtIDPesawat.setText(idPesawat);
    txtNmMaskapai.setText(nmMaskapai);
    txtTujuan.setText(tujuan);
    txtTglKeberangkatan.setText(tglKeberangkatan);
    txtWaktuKeberangkatan.setText(waktuKeberangkatan);
    }
    
    private void switchToPanelAdd() {
    panelMain.removeAll();
    panelMain.add(panelAdd);
    panelMain.repaint();
    panelMain.revalidate();
    }
    
    public void Simpan(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPesawat.getText());
        vLst.add(txtNmMaskapai.getText());
        vLst.add(txtTujuan.getText());
        vLst.add(txtTglKeberangkatan.getText());
        vLst.add(txtWaktuKeberangkatan.getText());
        
        o.setDataPesawat(vLst);
        o.simpanpesawat();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void update(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPesawat.getText());
        vLst.add(txtNmMaskapai.getText());
        vLst.add(txtTujuan.getText());
        vLst.add(txtTglKeberangkatan.getText());
        vLst.add(txtWaktuKeberangkatan.getText());
        
        o.setDataPesawat(vLst);
        o.updatepesawat();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void Hapus(){
        
        
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPesawat.getText());
        vLst.add(txtNmMaskapai.getText());
        vLst.add(txtTujuan.getText());
        vLst.add(txtTglKeberangkatan.getText());
        vLst.add(txtWaktuKeberangkatan.getText());
        
        o.setDataPesawat(vLst);
        o.hapuspesawat();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelAdd = new javax.swing.JPanel();
        btnCari = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIDPesawat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNmMaskapai = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTujuan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTglKeberangkatan = new javax.swing.JTextField();
        txtWaktuKeberangkatan = new javax.swing.JTextField();
        panelView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpesawat = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        panelMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Master Pesawat");

        panelAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel7.setText("ID Pesawat");

        txtIDPesawat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDPesawatFocusLost(evt);
            }
        });

        jLabel8.setText("Nama Maskapai");

        jLabel9.setText("Tujuan");

        jLabel10.setText("Tanggal Keberangkatan");

        jLabel11.setText("Waktu  Keberangkatan");

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(30, 30, 30)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWaktuKeberangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTglKeberangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelAddLayout.createSequentialGroup()
                            .addComponent(txtIDPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCari))
                        .addComponent(txtNmMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCari)
                    .addComponent(jLabel7)
                    .addComponent(txtIDPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtNmMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTglKeberangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtWaktuKeberangkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelpesawat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Pesawat", "Nama Maskapai", "Tujuan", "Tanggal Keberangkatan", "Waktu Keberangkatan"
            }
        ));
        tabelpesawat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpesawatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpesawat);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSimpan.setText("SIMPAN");
        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus)
                        .addGap(4, 4, 4)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
//        panelMain.removeAll();
        panelMain.add(panelView);
//        panelMain.repaint();
//        panelMain.revalidate();
    }//GEN-LAST:event_btnCariActionPerformed

    private void txtIDPesawatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDPesawatFocusLost
        // TODO add your handling code here:
        setIDPesawat(txtIDPesawat.getText());
    }//GEN-LAST:event_txtIDPesawatFocusLost

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        this.Simpan();
        bukaForm();
        txtIDPesawat.requestFocus();
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        this.update();
        bukaForm();
        txtIDPesawat.requestFocus();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        this.Hapus();
        bukaForm();
        txtIDPesawat.requestFocus();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void tabelpesawatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpesawatMouseClicked
        setDataFromTable(tabelpesawat.getSelectedRow());
    }//GEN-LAST:event_tabelpesawatMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JTable tabelpesawat;
    private javax.swing.JTextField txtIDPesawat;
    private javax.swing.JTextField txtNmMaskapai;
    private javax.swing.JTextField txtTglKeberangkatan;
    private javax.swing.JTextField txtTujuan;
    private javax.swing.JTextField txtWaktuKeberangkatan;
    // End of variables declaration//GEN-END:variables
}
