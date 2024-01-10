/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import ctr.ctrPenumpang;
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
public class menuPenumpangg extends javax.swing.JPanel {
    ctrPenumpang o = new ctrPenumpang();
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    dbConnection db = new dbConnection(); Connection con = db.koneksiDB();

    /**
     * Creates new form menuPenumpangg
     */
    public menuPenumpangg() {
        initComponents();
        judul();
        tampilData("");
    }
    
    public void judul() {
        Object[] judul = {
            "ID Penumpang", "Nama", "Alamat", "Email", "No Telp"
        };
        tabModel = new DefaultTableModel (null, judul);
        tabelpenumpang.setModel(tabModel);
    }
    
    public void tampilData(String where) {
        try {
            st = con.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs=st.executeQuery("SELECT * FROM penumpang" + where);
            
            while (rs.next()){
                Object[] data = {
                    rs.getString("id_penumpang"),
                    rs.getString("nama"),
                    rs.getString("alamat"),
                    rs.getString("email"),
                    rs.getString("notelp"),
                };
                tabModel.addRow(data);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void bukaForm(){
        txtIDPenumpang.setText("");
        txtNmPenumpang.setText("");
        txtAlamat.setText("");
        txtEmail.setText("");
        txtNoTelp.setText("");
    }
    
    public void setid_penumpang(String p){
        o.setIDPenumpang(p);
        txtIDPenumpang.setText(p);
        txtNmPenumpang.setText(o.getIDPenumpang().get(1));
        txtAlamat.setText(o.getIDPenumpang().get(2));
        txtEmail.setText(o.getIDPenumpang().get(3));
        txtNoTelp.setText(o.getIDPenumpang().get(4));
    }
    
    private void setDataFromTable(int row) {
    // Mendapatkan data dari tabel untuk baris yang diklik
    String idPenumpang = tabelpenumpang.getValueAt(row, 0).toString();
    String nmPenumpang = tabelpenumpang.getValueAt(row, 1).toString();
    String alamat = tabelpenumpang.getValueAt(row, 2).toString();
    String email = tabelpenumpang.getValueAt(row, 3).toString();
    String noTelp = tabelpenumpang.getValueAt(row, 4).toString();
    
    // Mengisi data pada panelAdd
    txtIDPenumpang.setText(idPenumpang);
    txtNmPenumpang.setText(nmPenumpang);
    txtAlamat.setText(alamat);
    txtEmail.setText(email);
    txtNoTelp.setText(noTelp);
    }
    
    private void switchToPanelAdd() {
    panelMain.removeAll();
    panelMain.add(panelAdd);
    panelMain.repaint();
    panelMain.revalidate();
    }
    
    public void simpan(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPenumpang.getText());
        vLst.add(txtNmPenumpang.getText());
        vLst.add(txtAlamat.getText());
        vLst.add(txtEmail.getText());
        vLst.add(txtNoTelp.getText());
        
        o.setDataPenumpang(vLst);
        o.simpanpenumpang();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void hapus(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPenumpang.getText());
        vLst.add(txtNmPenumpang.getText());
        vLst.add(txtAlamat.getText());
        vLst.add(txtEmail.getText());
        vLst.add(txtNoTelp.getText());
        
        o.setDataPenumpang(vLst);
        o.hapusspenumpang();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
        // Memanggil kembali method tampilData untuk memperbarui tabel
        tampilData("");
    }
    
    public void update(){
        ArrayList<String> vLst = new ArrayList<String>();
        vLst.add(txtIDPenumpang.getText());
        vLst.add(txtNmPenumpang.getText());
        vLst.add(txtAlamat.getText());
        vLst.add(txtEmail.getText());
        vLst.add(txtNoTelp.getText());
        
        o.setDataPenumpang(vLst);
        o.updatepenumpang();
        
        javax.swing.JOptionPane.showMessageDialog(this, "Data berhasil diperbaharui!");
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
        jLabel2 = new javax.swing.JLabel();
        txtIDPenumpang = new javax.swing.JTextField();
        btncari = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtNmPenumpang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNoTelp = new javax.swing.JTextField();
        panelView = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelpenumpang = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        panelMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Master Penumpang");

        panelAdd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("ID Penumpang");

        txtIDPenumpang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDPenumpangFocusLost(evt);
            }
        });
        txtIDPenumpang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDPenumpangActionPerformed(evt);
            }
        });

        btncari.setText("Cari");
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText("Email");

        jLabel6.setText("No. Telp");

        txtNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoTelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAddLayout = new javax.swing.GroupLayout(panelAdd);
        panelAdd.setLayout(panelAddLayout);
        panelAddLayout.setHorizontalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(39, 39, 39)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAddLayout.createSequentialGroup()
                        .addComponent(txtIDPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btncari)
                        .addContainerGap())
                    .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAlamat, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelAddLayout.createSequentialGroup()
                            .addComponent(txtNmPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(222, Short.MAX_VALUE))
                        .addGroup(panelAddLayout.createSequentialGroup()
                            .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))))
        );
        panelAddLayout.setVerticalGroup(
            panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNmPenumpang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabelpenumpang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No", "ID Penumpang", "Nama", "Alamat", "Email", "No Telp"
            }
        ));
        jScrollPane1.setViewportView(tabelpenumpang);

        javax.swing.GroupLayout panelViewLayout = new javax.swing.GroupLayout(panelView);
        panelView.setLayout(panelViewLayout);
        panelViewLayout.setHorizontalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        panelViewLayout.setVerticalGroup(
            panelViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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

        btnHapus.setText("HAPUS");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelMainLayout = new javax.swing.GroupLayout(panelMain);
        panelMain.setLayout(panelMainLayout);
        panelMainLayout.setHorizontalGroup(
            panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAdd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(10, 10, 10)
                .addComponent(btnUbah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus)
                .addGap(24, 24, 24))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDPenumpangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDPenumpangFocusLost
        this.setid_penumpang(txtIDPenumpang.getText());
    }//GEN-LAST:event_txtIDPenumpangFocusLost

    private void txtIDPenumpangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDPenumpangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDPenumpangActionPerformed

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
//        panelMain.removeAll();
        panelMain.add(panelView);
//        panelMain.repaint();
//        panelMain.revalidate();
    }//GEN-LAST:event_btncariActionPerformed

    private void txtNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoTelpActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
       this.simpan();
        bukaForm();
        txtIDPenumpang.requestFocus();
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        this.hapus();
        bukaForm();
        txtIDPenumpang.requestFocus();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        this.update();
        bukaForm();
        txtIDPenumpang.requestFocus();
    }//GEN-LAST:event_btnUbahMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        setDataFromTable(tabelpenumpang.getSelectedRow());
    }//GEN-LAST:event_jScrollPane1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JButton btncari;
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
    private javax.swing.JTable tabelpenumpang;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDPenumpang;
    private javax.swing.JTextField txtNmPenumpang;
    private javax.swing.JTextField txtNoTelp;
    // End of variables declaration//GEN-END:variables
}
