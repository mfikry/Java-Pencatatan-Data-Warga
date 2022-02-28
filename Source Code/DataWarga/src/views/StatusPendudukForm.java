/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import controllers.PendudukController;
import controllers.StatusPendudukController;
import java.util.ArrayList;
import models.Penduduk;
import models.OperasiCRUD;
import models.StatusPenduduk;
/**
 *
 * @author fikry
 */
public class StatusPendudukForm extends javax.swing.JInternalFrame implements Observer {
    private StatusPendudukController spController = new StatusPendudukController();
    private PendudukController pController = new PendudukController();
    DefaultTableModel tabelModel;
    /**
     * Creates new form StatusPendudukForm
     */
    
    
    public StatusPendudukForm() {
        initComponents();
        spController.addObserver(this);
        setPenduduk(pController.getAllPenduduk());
        setTabelStatus(spController.getAllStatus());
        setHubunganKeluarga();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resetForm();
    }
    private void setPenduduk(List<Penduduk> pens){
        if(pens == null){
            JOptionPane.showMessageDialog(this, "Data Penduduk tidak Ada"
                        + "Diload","Gagal Koneksi", JOptionPane.ERROR_MESSAGE);
        }else{
            cbxPenduduk.setModel(new DefaultComboBoxModel(pens.toArray()));
        }
    }
    private void resetForm(){
        txtstatus_perkawinan.setText(null);
        cbxhubungan_keluaga.setSelectedItem(0);
        txtkewarganegaraan.setText(null);
        txtdokumen.setText(null);
        txtayah.setText(null);
        txtibu.setText(null);
        btnUbah.setEnabled(false);
        btnSimpan.setEnabled(true);
        btnHapus.setEnabled(false);
        btnTambah.setEnabled(false);
    }
    private void tableToForm(){
        int rowIndex = tblStatusPenduduk.getSelectedRow();
        cbxPenduduk.setSelectedIndex(rowIndex);
        
        txtstatus_perkawinan.setText(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),2)+"");
        cbxhubungan_keluaga.setSelectedItem(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),3)+"");
        txtkewarganegaraan.setText(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),4)+"");
        txtdokumen.setText(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),5)+"");
        txtayah.setText(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),6)+"");
        txtibu.setText(tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),7)+"");
        btnSimpan.setEnabled(false);
        btnUbah.setEnabled(true);
        btnHapus.setEnabled(true);
        btnTambah.setEnabled(true);
    }
    private void setTabelStatus(List<StatusPenduduk>daftarStatus){
        if(daftarStatus == null){
            JOptionPane.showMessageDialog(this, "Data Status tidak Ada"
                        + "Diload","Gagal Koneksi", JOptionPane.ERROR_MESSAGE);
        }else{
            tabelModel = new DefaultTableModel();
            tabelModel.setColumnIdentifiers(new String[]{
            "Kode", "NIK", "Status Perkawinan","Hubungan Keluarga","Kewarganegaraan","Dokumen Imigrasi","Nama Ayah","Nama Ibu"
        });
            for(StatusPenduduk sp : daftarStatus){
                Object[] o = new Object[9];
                o[0] = sp.getkodestat();
                o[1] = sp.getstatus_perkawinan();
                o[2] = sp.gethubungan_keluarga();
                o[3] = sp.getkewarganegaraan();
                o[4] = sp.getdokumen_imigrasi();
                o[5] = sp.getnama_ayah();
                o[6] = sp.getnama_ibu();
                o[7] = sp.getPenduduk();
                tabelModel.addRow(o);
            }
            tblStatusPenduduk.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tblStatusPenduduk.setModel(tabelModel);
        }
    }
    public void update(Observable o, Object arg){
        if(o == spController){
            StatusPenduduk sp = (StatusPenduduk)arg;
            if(spController.getCrudState()== OperasiCRUD.INSERT){
                JOptionPane.showMessageDialog(this,"Data Berhasil di Simpan");
            }else if(spController.getCrudState()== OperasiCRUD.UPDATE){
                JOptionPane.showMessageDialog(this,"Data Berhasil di Update");
            }else if(spController.getCrudState()== OperasiCRUD.DELETE){
                JOptionPane.showMessageDialog(this,"Data Berhasil di Hapus");
            }
            setTabelStatus(spController.getAllStatus());
            resetForm();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        q = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtstatus_perkawinan = new javax.swing.JTextField();
        txtkewarganegaraan = new javax.swing.JTextField();
        txtdokumen = new javax.swing.JTextField();
        txtayah = new javax.swing.JTextField();
        cbxPenduduk = new javax.swing.JComboBox();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtibu = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStatusPenduduk = new javax.swing.JTable();
        cbxhubungan_keluaga = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Status Penduduk");

        jLabel2.setText("NIK");

        q.setText("Status Perkawinan");

        jLabel4.setText("Hubungan keluarga");

        jLabel5.setText("Kewarganegaraan");

        jLabel6.setText("Dokumen Imigrasi");

        jLabel7.setText("Nama Ayah");

        txtkewarganegaraan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkewarganegaraanActionPerformed(evt);
            }
        });

        cbxPenduduk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxPenduduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPendudukActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Tutup");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Ibu");

        tblStatusPenduduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblStatusPenduduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStatusPendudukMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblStatusPenduduk);

        cbxhubungan_keluaga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxhubungan_keluaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxhubungan_keluagaActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(q)
                            .addComponent(jLabel2))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtayah, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtdokumen, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtkewarganegaraan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxhubungan_keluaga, javax.swing.GroupLayout.Alignment.LEADING, 0, 272, Short.MAX_VALUE)
                                .addComponent(txtstatus_perkawinan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbxPenduduk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtibu)))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 57, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbxPenduduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q)
                            .addComponent(txtstatus_perkawinan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbxhubungan_keluaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtkewarganegaraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtdokumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtayah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtibu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnUbah)
                            .addComponent(btnHapus)
                            .addComponent(btnKeluar)
                            .addComponent(btnTambah))
                        .addGap(107, 107, 107))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtkewarganegaraanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkewarganegaraanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkewarganegaraanActionPerformed
    
    private boolean check() {
        ArrayList<String> numdata = new ArrayList<String>();

        for(int count = 0; count < tabelModel.getRowCount(); count++){
            numdata.add(tabelModel.getValueAt(count, 1).toString());
        }
        Penduduk pen = (Penduduk)cbxPenduduk.getSelectedItem();
        String x = pen + "";
        for (int i = 0; i < numdata.size(); i++) {
            if (numdata.get(i).equals(x)) {
                return true;
            }
        }
        
        return false;
    }
    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        Penduduk pen = (Penduduk)cbxPenduduk.getSelectedItem();
        if(check()){
            JOptionPane.showMessageDialog(null, "Data sudah ada, dengan nik: " + pen);
        } else {
            String status_perkawinan = txtstatus_perkawinan.getText();
            String hubungan_keluarga = cbxhubungan_keluaga.getSelectedItem().toString();
            String kewarganegaraan = txtkewarganegaraan.getText();
            String dokumen_imigrasi = txtdokumen.getText();
            String nama_ayah = txtayah.getText();
            String nama_ibu = txtibu.getText();
            StatusPenduduk sp = new StatusPenduduk(status_perkawinan,hubungan_keluarga,kewarganegaraan,dokumen_imigrasi,nama_ayah,nama_ibu,pen);
            spController.setDml(sp, OperasiCRUD.INSERT);
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cbxPendudukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPendudukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPendudukActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        Penduduk pen = (Penduduk)cbxPenduduk.getSelectedItem();
        String getKode = tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),0).toString();
        int kodestat = Integer.parseInt(getKode);
        String status_perkawinan = txtstatus_perkawinan.getText();
        String hubungan_keluarga = (String) cbxhubungan_keluaga.getSelectedItem();
        String kewarganegaraan = txtkewarganegaraan.getText();
        String dokumen = txtdokumen.getText();
        String ayah = txtayah.getText();
        String ibu = txtibu.getText();
        StatusPenduduk sp = new StatusPenduduk(kodestat,status_perkawinan,hubungan_keluarga,kewarganegaraan,dokumen,ayah,ibu,pen);
        spController.setDml(sp, OperasiCRUD.UPDATE);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        String getKode = tabelModel.getValueAt(tblStatusPenduduk.getSelectedRow(),0).toString();
        int kodestat = Integer.parseInt(getKode);
        Penduduk pen = (Penduduk)cbxPenduduk.getSelectedItem();
        StatusPenduduk sp = new StatusPenduduk(pen, kodestat);
        int hapus = JOptionPane.showConfirmDialog(null,"Apakah "
                + "Anda Yakin Ingin Menghapus Data", null, JOptionPane.YES_NO_OPTION);
        if(hapus == JOptionPane.YES_OPTION){
            spController.setDml(sp, OperasiCRUD.DELETE);
        }
        resetForm();
    }//GEN-LAST:event_btnHapusActionPerformed
    
    public void setHubunganKeluarga() {
        if (cbxhubungan_keluaga.getItemCount() != 0) {
            cbxhubungan_keluaga.removeAllItems();
            cbxhubungan_keluaga.addItem("KEPALA KELUARGA");
            cbxhubungan_keluaga.addItem("SUAMI");
            cbxhubungan_keluaga.addItem("ISTERI");
            cbxhubungan_keluaga.addItem("ORANG TUA");
            cbxhubungan_keluaga.addItem("ANAK");
            cbxhubungan_keluaga.addItem("CUCU");
            cbxhubungan_keluaga.addItem("MENANTU");
            cbxhubungan_keluaga.addItem("MERTUA");
            cbxhubungan_keluaga.addItem("LAINNYA");
        } else {
            JOptionPane.showMessageDialog(null, "Data kosong!");
        }
    }
    private void cbxhubungan_keluagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxhubungan_keluagaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbxhubungan_keluagaActionPerformed

    private void tblStatusPendudukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStatusPendudukMouseClicked
        // TODO add your handling code here:
        tableToForm();
    }//GEN-LAST:event_tblStatusPendudukMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        resetForm();
    }//GEN-LAST:event_btnTambahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatusPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatusPendudukForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox cbxPenduduk;
    private javax.swing.JComboBox<String> cbxhubungan_keluaga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel q;
    private javax.swing.JTable tblStatusPenduduk;
    private javax.swing.JTextField txtayah;
    private javax.swing.JTextField txtdokumen;
    private javax.swing.JTextField txtibu;
    private javax.swing.JTextField txtkewarganegaraan;
    private javax.swing.JTextField txtstatus_perkawinan;
    // End of variables declaration//GEN-END:variables
}
