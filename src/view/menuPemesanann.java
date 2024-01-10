/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctr.ctrPemesanan;
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
public class menuPemesanann extends javax.swing.JPanel {
    ctrPemesanan o = new ctrPemesanan();
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    dbConnection db = new dbConnection(); Connection con = db.koneksiDB();

    /**
     * Creates new form menuPemesanann
     */
    public menuPemesanann() {
        initComponents();
        judul();
        tampilData("");
    }
    
    public void judul() {
        Object[] judul = {
            "ID Pemesanan", "Nomor Tiket", "Tanggal Pemesanan", "Nama Pemesanan", "Status"
        };
        tabModel = new DefaultTableModel (null, judul);
        tabelpemesanan.setModel(tabModel);
    }
    public void tampilData(String where) {
        try {
            st = con.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs=st.executeQuery("SELECT * FROM pemesanan" + where);
            
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_pemesanan"),
                    rs.getString("nomor_tiket"),                    
                    rs.getString("tanggal_pmsn"),
                    rs.getString("nama_pmsn"),
                    rs.getString("status"),
                };
                tabModel.addRow(data);
            }
        } catch(Exception e) {
            e.printStackTrace();
    }
    }        
        
    public void bukaForm(){
        txtIdPemesanan.setText("");
        txtNotiket.setText("");
        txtTanggalpmsn.setText("");
        txtKelas.setText("");
        txtStatus.setText("");        
    }
    
    public void setIDPemesanan(String p){
        o.setid_pemesanan(p);
        txtIdPemesanan.setText(p);
        txtTanggalpmsn.setText(o.getIDPesanan().get(1));
        txtNotiket.setText(o.getIDPesanan().get(2));
        txtKelas.setText(o.getIDPesanan().get(3));
        txtStatus.setText(o.getIDPesanan().get(4));
    }
    private void setDataFromTable(int row) {
    // Mendapatkan data dari tabel untuk baris yang diklik
    String nomorpemesanan = tabelpemesanan.getValueAt(row, 0).toString();
    String tanggalpemesanan = tabelpemesanan.getValueAt(row, 1).toString();
    String notiket = tabelpemesanan.getValueAt(row, 2).toString();
    String kelas = tabelpemesanan.getValueAt(row, 3).toString();    
    String status = tabelpemesanan.getValueAt(row, 4).toString();
    
    // Mengisi data pada panelAdd
    txtIdPemesanan.setText(nomorpemesanan);
    txtTanggalpmsn.setText(tanggalpemesanan);
    txtNotiket.setText(notiket);
    txtKelas.setText(kelas);
    txtStatus.setText(status);
    }
    
    private void switchToPanelAdd() {
    panelMain.removeAll();
    panelMain.add(panelAdd);
    panelMain.repaint();
    panelMain.revalidate();
    }
    
    public void save(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIdPemesanan.getText());
        vLst.add(txtTanggalpmsn.getText());
        vLst.add(txtNotiket.getText());
        vLst.add(txtKelas.getText());
        vLst.add(txtStatus.getText());
        
        o.setDataPemesanan(vLst);
        o.save();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void update(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIdPemesanan.getText());
        vLst.add(txtTanggalpmsn.getText());
        vLst.add(txtNotiket.getText());
        vLst.add(txtKelas.getText());
        vLst.add(txtStatus.getText());
        
        o.setDataPemesanan(vLst);
        o.edit();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void delete(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIdPemesanan.getText());
        vLst.add(txtTanggalpmsn.getText());
        vLst.add(txtNotiket.getText());
        vLst.add(txtKelas.getText());
        vLst.add(txtStatus.getText());
        
        o.setDataPemesanan(vLst);
        o.delete();
        
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
        txtIdPemesanan = new javax.swing.JTextField();
        txtNotiket = new javax.swing.JTextField();
        txtKelas = new javax.swing.JTextField();
        txtTanggalpmsn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCari = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        panelView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpemesanan = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        panelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Master Pemesanan");

        panelAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtIdPemesanan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdPemesananFocusLost(evt);
            }
        });
        txtIdPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPemesananActionPerformed(evt);
            }
        });

        txtNotiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotiketActionPerformed(evt);
            }
        });

        jLabel2.setText("Nomor Pemesanan");

        jLabel3.setText("Tanggal Pemesanan");

        jLabel4.setText("Kelas");

        jLabel5.setText("Status");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel6.setText("Nomor Tiket");

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(49, 49, 49)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTanggalpmsn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNotiket, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdPemesanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCari)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtNotiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTanggalpmsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelpemesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nomor Pemesanan", "Nomor Tiket", "Tanggal Pemesanan", "Kelas", "Status"
            }
        ));
        tabelpemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelpemesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelpemesanan);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        btnSimpan.setText("Simpan");
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

        btnUbah.setText("Ubah");
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

        btnHapus.setText("Hapus");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addGap(87, 87, 87)))
                .addContainerGap())
        );
        panelMainLayout.setVerticalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(panelAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelView, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void txtIdPemesananFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdPemesananFocusLost
        // TODO add your handling code here:
        setIDPemesanan(txtIdPemesanan.getText());
    }//GEN-LAST:event_txtIdPemesananFocusLost

    private void txtIdPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPemesananActionPerformed

    private void txtNotiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotiketActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
//        panelMain.removeAll();
        panelMain.add(panelView);
//        panelMain.repaint();
//        panelMain.revalidate();
    }//GEN-LAST:event_btnCariActionPerformed

    private void tabelpemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelpemesananMouseClicked
        // TODO add your handling code here:
        setDataFromTable(tabelpemesanan.getSelectedRow());
    }//GEN-LAST:event_tabelpemesananMouseClicked

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        this.save();
        bukaForm();
        txtIdPemesanan.requestFocus();
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        this.update();
        bukaForm();
        txtIdPemesanan.requestFocus();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        this.delete();
        bukaForm();
        txtIdPemesanan.requestFocus();
    }//GEN-LAST:event_btnHapusMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelAdd;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelView;
    private javax.swing.JTable tabelpemesanan;
    private javax.swing.JTextField txtIdPemesanan;
    private javax.swing.JTextField txtKelas;
    private javax.swing.JTextField txtNotiket;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTanggalpmsn;
    // End of variables declaration//GEN-END:variables
}
