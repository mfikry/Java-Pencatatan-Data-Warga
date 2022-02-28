/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import connect.Koneksi;
import controllers.PendudukController;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Penduduk;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author Naufal
 */
public class LaporanPendudukForm extends javax.swing.JInternalFrame {
    private PendudukController pController = new PendudukController();
    DefaultTableModel tabelModel;
    ButtonGroup bg = new ButtonGroup();
    /**
     * Creates new form LaporanForm
     */
    public LaporanPendudukForm() {
        initComponents();
        setTabelUmur(pController.getAllPenduduk());
        addToGroup();
        
    }
    private void addToGroup() {
        bg.add(allRadio);
        bg.add(umrAtasRadio);
        bg.add(umrBawahRadio);
        bg.add(jpTetapRadio);
        bg.add(jpKontrakRadio);
        bg.add(jpSementaraRadio);
        bg.add(jpLainRadio);
    }
    
    private String getSelected() {
        if (allRadio.isSelected()) {
            return "All";
        } else if (umrAtasRadio.isSelected()) {
            return "(^(?:[1-9]\\d{2,}+|[2-9]\\d|1[789])$)";
        } else if (umrBawahRadio.isSelected()) {
            return "(^([0-9]|1[0-6])$)";
        } else if (jpTetapRadio.isSelected()) {
            return "TETAP";
        } else if (jpKontrakRadio.isSelected()) {
            return "KONTRAK";
        } else if (jpSementaraRadio.isSelected()) {
            return "SEMENTARA";
        } else if (jpLainRadio.isSelected()) {
            return "LAINNYA";
        } else {
            return "All";
        }
    }
    
    private int getSelectedIndex() {
        if (allRadio.isSelected()) {
            return 0;
        } else if (umrAtasRadio.isSelected()) {
            return 1;
        } else if (umrBawahRadio.isSelected()) {
            return 2;
        } else if (jpTetapRadio.isSelected()) {
            return 3;
        } else if (jpKontrakRadio.isSelected()) {
            return 4;
        } else if (jpSementaraRadio.isSelected()) {
            return 5;
        } else if (jpLainRadio.isSelected()) {
            return 6;
        } else {
            return 0;
        }
    }
    
    private void setTabelUmur(List<Penduduk> lsPenduduk){
        if(lsPenduduk == null){
            JOptionPane.showMessageDialog(this, "Penduduk tidak bisa diload",
                    "Gagal Koneksi", JOptionPane.ERROR_MESSAGE);
        }else{
            tabelModel = new DefaultTableModel();
            tabelModel.setColumnIdentifiers (new String[]{
                "NIK","Nama","Jenis Kelamin","Tempat Lahir","Tanggal Lahir","Agama","Pendidikan","Jenis Pekerjaan","Alamat","Jenis Penduduk", "Umur"
            });
            for(Penduduk p : lsPenduduk){
                String x = p.gettanggal_lahir();
                String year = x.substring(0, 4);
                String month = x.substring(5, 7);
                String day = x.substring(8, 10);
                int y = Integer.parseInt(year);
                int m = Integer.parseInt(month);
                int d = Integer.parseInt(day);
                LocalDate birthdate = new LocalDate (y, m, d);      
                LocalDate now = new LocalDate();                        
                Period period = new Period(birthdate, now, PeriodType.yearMonthDay());
                String str = String.valueOf(period.getYears());
                
                
                Object[] o = new Object[11];
                o[0] = p.getnik();
                o[1] = p.getnamapen();
                o[2] = p.getjenis_kelamin();
                o[3] = p.gettempat_lahir();
                o[4] = p.gettanggal_lahir();
                o[5] = p.getagama();
                o[6] = p.getpendidikan();
                o[7] = p.getjenis_pekerjaan();
                o[8] = p.getalamat();
                o[9] = p.getjenis_penduduk();
                o[10] = str;
                tabelModel.addRow(o);
            }
            tableLaporan.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
            tableLaporan.setModel(tabelModel);
        }
    }
        
    private void filter(String query) {
        
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tabelModel);
        tableLaporan.setRowSorter(tr);
        
        if (query != "All") {
            tr.setRowFilter(RowFilter.regexFilter(query));
        } else {
            tableLaporan.setRowSorter(tr);
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

        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLaporan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cetakBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        allRadio = new javax.swing.JRadioButton();
        umrAtasRadio = new javax.swing.JRadioButton();
        umrBawahRadio = new javax.swing.JRadioButton();
        jpTetapRadio = new javax.swing.JRadioButton();
        jpKontrakRadio = new javax.swing.JRadioButton();
        jpSementaraRadio = new javax.swing.JRadioButton();
        jpLainRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        tableLaporan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableLaporan);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Filter umur");

        cetakBtn.setText("Cetak");
        cetakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Filter Jenis Penduduk");

        allRadio.setSelected(true);
        allRadio.setText("All");
        allRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                allRadioItemStateChanged(evt);
            }
        });

        umrAtasRadio.setText("Umur diatas 17 tahun");
        umrAtasRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                umrAtasRadioItemStateChanged(evt);
            }
        });

        umrBawahRadio.setText("Umur dibawah 17 tahun");
        umrBawahRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                umrBawahRadioItemStateChanged(evt);
            }
        });

        jpTetapRadio.setText("Jenis Penduduk Tetap");
        jpTetapRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jpTetapRadioItemStateChanged(evt);
            }
        });

        jpKontrakRadio.setText("Jenis Penduduk Kontrak");
        jpKontrakRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jpKontrakRadioItemStateChanged(evt);
            }
        });

        jpSementaraRadio.setText("Jenis Penduduk Sementara");
        jpSementaraRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jpSementaraRadioItemStateChanged(evt);
            }
        });
        jpSementaraRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpSementaraRadioActionPerformed(evt);
            }
        });

        jpLainRadio.setText("Jenis Penduduk Lainnya");
        jpLainRadio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jpLainRadioItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cetakBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1251, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(allRadio)
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(umrAtasRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(umrBawahRadio))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jpTetapRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpKontrakRadio)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTutup)
                                .addGap(22, 22, 22))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpSementaraRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpLainRadio)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTutup)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(allRadio))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(umrAtasRadio)
                                .addComponent(umrBawahRadio)
                                .addComponent(jpTetapRadio)
                                .addComponent(jpKontrakRadio)
                                .addComponent(jpSementaraRadio)
                                .addComponent(jpLainRadio)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(cetakBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void cetakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakBtnActionPerformed
        // TODO add your handling code here:
        int getItem = getSelectedIndex();
        switch (getItem) {
            case 0:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/UmurAll.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 1:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/UmurDiatas17.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 2:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/UmurDibawah17.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 3:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/jpTetap.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 4:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/jpKontrak.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 5:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/jpSementara.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
            case 6:
                try {
                JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/views/LaporanDataPenduduk/jpLain.jasper"), null, Koneksi.bukaKoneksi());
                JasperViewer.viewReport(jp, false);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
                }
                break;
        }
    }//GEN-LAST:event_cetakBtnActionPerformed

    private void allRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_allRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_allRadioItemStateChanged

    private void jpTetapRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jpTetapRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_jpTetapRadioItemStateChanged

    private void jpKontrakRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jpKontrakRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_jpKontrakRadioItemStateChanged

    private void jpSementaraRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jpSementaraRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_jpSementaraRadioItemStateChanged

    private void jpLainRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jpLainRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_jpLainRadioItemStateChanged

    private void umrAtasRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_umrAtasRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_umrAtasRadioItemStateChanged

    private void umrBawahRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_umrBawahRadioItemStateChanged
        // TODO add your handling code here:
        String query = getSelected();
        filter(query);
    }//GEN-LAST:event_umrBawahRadioItemStateChanged

    private void jpSementaraRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpSementaraRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jpSementaraRadioActionPerformed

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
            java.util.logging.Logger.getLogger(LaporanPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanPendudukForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanPendudukForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allRadio;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton cetakBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton jpKontrakRadio;
    private javax.swing.JRadioButton jpLainRadio;
    private javax.swing.JRadioButton jpSementaraRadio;
    private javax.swing.JRadioButton jpTetapRadio;
    private javax.swing.JTable tableLaporan;
    private javax.swing.JRadioButton umrAtasRadio;
    private javax.swing.JRadioButton umrBawahRadio;
    // End of variables declaration//GEN-END:variables

}
