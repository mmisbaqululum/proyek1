/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frontend;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import backend.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class BrgMasuk extends javax.swing.JFrame {
    Barang b = new Barang();
    LaporanBackend l = new LaporanBackend();
    /**
     * Creates new form BrgMasuk
     */
    public BrgMasuk() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }
    
    public void tampilkanData(){
        String[] kolom = {"Id Barang", "Jenis Barang", "Nama Barang", "Stok", "Harga", "Total"};
        ArrayList<Barang> list = new Barang().getAll();
        Object rowData[] = new Object[6];
        
        jTableBarang.setModel(new DefaultTableModel(new Object[][] {}, kolom));
        for (Barang br : list) {
            rowData[0] = br.getId_barang();
            rowData[1] = br.getJenis();
            rowData[2] = br.getNama_barang();
            rowData[3] = br.getStok();
            rowData[4] = br.getHarga();
            rowData[5] = br.getStok() * br.getHarga();
            
            ((DefaultTableModel)jTableBarang.getModel()).addRow(rowData);
        }
    }
    
    public void kosongkanForm(){
        jTextId.setText("0");
        jComboBox1.setSelectedItem(null);
        jTextNama.setText("");
        jTextStok.setText("");
        jTextHarga.setText("");        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tambahButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextNama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextStok = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextHarga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableBarang = new javax.swing.JTable();
        ubahButton = new javax.swing.JButton();
        hitungButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextId = new javax.swing.JTextField();
        kirimButton = new javax.swing.JButton();
        hasil = new javax.swing.JTextField();
        jButtonKurang = new javax.swing.JButton();
        jTextSisa = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setText("FORM BARANG MASUK");

        tambahButton.setText("Tambah");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("NAMA BARANG");

        jTextNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNamaActionPerformed(evt);
            }
        });

        jLabel9.setText("STOK");

        jTextStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextStokActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kering", "Basah" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("JENIS BARANG");

        jLabel6.setText("HARGA");

        jTableBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableBarang);

        ubahButton.setText("Ubah");
        ubahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahButtonActionPerformed(evt);
            }
        });

        hitungButton.setText("Hitung");
        hitungButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("ID BARANG");

        jTextId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdActionPerformed(evt);
            }
        });

        kirimButton.setText("Kirim");
        kirimButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirimButtonActionPerformed(evt);
            }
        });

        jButtonKurang.setText("Stok Sisa");
        jButtonKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKurangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextHarga)
                            .addComponent(jTextStok)
                            .addComponent(jTextNama)
                            .addComponent(jComboBox1, 0, 408, Short.MAX_VALUE)
                            .addComponent(jTextId)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(kirimButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonKurang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hitungButton, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextSisa)
                            .addComponent(hasil))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonKurang)
                    .addComponent(jTextSisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahButton)
                    .addComponent(ubahButton)
                    .addComponent(hitungButton)
                    .addComponent(hasil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kirimButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        Barang b = new Barang();
        b.setId_barang(Integer.parseInt(jTextId.getText()));
        b.setJenis(String.valueOf(jComboBox1.getSelectedItem()));
        b.setNama_barang(jTextNama.getText());
        b.setStok(Integer.parseInt(jTextStok.getText()));
        b.setHarga(Integer.parseInt(jTextHarga.getText()));
        b.save();
        tampilkanData();
        
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void ubahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahButtonActionPerformed
        // TODO add your handling code here:
        Barang b = new Barang();
        b.setId_barang(Integer.parseInt(jTextId.getText()));
        b.setJenis(String.valueOf(jComboBox1.getSelectedItem()));
        b.setNama_barang(jTextNama.getText());
        b.setStok(Integer.parseInt(jTextStok.getText()));
        b.setHarga(Integer.parseInt(jTextHarga.getText()));
        b.save();
        tampilkanData();
        kosongkanForm();
    }//GEN-LAST:event_ubahButtonActionPerformed

    
//    private void jTableBarangMouseClicked(java.awt.event.MouseEvent evt) {                                         
//        // TODO add your handling code here:
//
//        DefaultTableModel m = (DefaultTableModel) jTableBarang.getModel();
//        int row = jTableBarang.getSelectedRow();
//        
//        jTextId.setText(m.getValueAt(row, 0).toString());
//        jComboBox1.setSelectedItem(m.getValueAt(row, 1).toString());
//        jTextNama.setText(m.getValueAt(row, 2).toString());
//        jTextStok.setText(m.getValueAt(row, 3).toString());
//        jTextHarga.setText(m.getValueAt(row, 4).toString());
//        
//
//    }    
    private void hitungButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungButtonActionPerformed
        // TODO add your handling code here:
        Barang b = new Barang();
        hasil.setText(Integer.toString(b.hitung(Integer.parseInt(jTextStok.getText()),Integer.parseInt(jTextHarga.getText()))));
    }//GEN-LAST:event_hitungButtonActionPerformed

    private void jTextIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdActionPerformed

    private void jTextStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextStokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextStokActionPerformed

    private void jTextNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNamaActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBarangMouseClicked
        // TODO add your handling code here:
        DefaultTableModel m = (DefaultTableModel) jTableBarang.getModel();
        int row = jTableBarang.getSelectedRow();
        
        jTextId.setText(m.getValueAt(row, 0).toString());
        jComboBox1.setSelectedItem(m.getValueAt(row, 1).toString());
        jTextNama.setText(m.getValueAt(row, 2).toString());
        jTextStok.setText(m.getValueAt(row, 3).toString());
        jTextHarga.setText(m.getValueAt(row, 4).toString());
    }//GEN-LAST:event_jTableBarangMouseClicked

    private void kirimButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirimButtonActionPerformed
        // TODO add your handling code here:
        LaporanBackend l = new LaporanBackend();
        l.setId_laporan(Integer.parseInt(jTextId.getText()));
        l.setJenis_barang(String.valueOf(jComboBox1.getSelectedItem()));
        l.setNama_barang(jTextNama.getText());
        l.setStok(Integer.parseInt(jTextStok.getText()));
        l.setHarga(Integer.parseInt(jTextHarga.getText()));
        l.setTotal(Integer.parseInt(hasil.getText()));
        l.kirim();
        Barang b=new Barang();
        b.setId_barang(Integer.parseInt(jTextId.getText()));
        b.setJenis(String.valueOf(jComboBox1.getSelectedItem()));
        b.setNama_barang(jTextNama.getText());
        b.setStok(Integer.parseInt(jTextSisa.getText()));
        b.setHarga(Integer.parseInt(jTextHarga.getText()));
        b.save();
        tampilkanData();
        
        //b.delete();
  

        //coba
        
        
        Laporan f = new Laporan();
        f.setVisible(true);
        this.setVisible(false);
        tampilkanData();
        JOptionPane.showMessageDialog(null,"Berhasil Menambah Data Ke Laporan");   
    }//GEN-LAST:event_kirimButtonActionPerformed

    private void jButtonKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKurangActionPerformed
        // TODO add your handling code here:
        DefaultTableModel m = (DefaultTableModel) jTableBarang.getModel();
        int row = jTableBarang.getSelectedRow();
        String awal=m.getValueAt(row, 3).toString();
        Barang b = new Barang();
        jTextSisa.setText(Integer.toString(b.kurang(Integer.parseInt(awal),Integer.parseInt(jTextStok.getText()))));
    }//GEN-LAST:event_jButtonKurangActionPerformed

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
            java.util.logging.Logger.getLogger(BrgMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrgMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrgMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrgMasuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrgMasuk().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hasil;
    private javax.swing.JButton hitungButton;
    private javax.swing.JButton jButtonKurang;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableBarang;
    private javax.swing.JTextField jTextHarga;
    private javax.swing.JTextField jTextId;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextSisa;
    private javax.swing.JTextField jTextStok;
    private javax.swing.JButton kirimButton;
    private javax.swing.JButton tambahButton;
    private javax.swing.JButton ubahButton;
    // End of variables declaration//GEN-END:variables
}
