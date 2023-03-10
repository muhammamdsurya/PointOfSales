package com.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author muham
 */
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;

public class Struk extends javax.swing.JFrame {

    /**
     * Creates new form Struk
     */
    
    public Struk() {
        initComponents();
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
        printTxt = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        printTxt.setColumns(20);
        printTxt.setRows(5);
        jScrollPane1.setViewportView(printTxt);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String ltotal;
    String lbayar;
    String lbalance;
    String date;
    String kasir;
   public Struk(String kasir, String date, String total, String bayar, String balance, TableModel model) {
        try {
            initComponents();
            this.ltotal = total;
            this.lbayar = bayar;
            this.lbalance = balance; 
            this.date = date;
            this.kasir = kasir;
            
            printTxt.setText(printTxt.getText()+ "=====================================================\n");
            printTxt.setText(printTxt.getText()+ "==================STRUK PEMBELIAN====================\n");
            printTxt.setText(printTxt.getText()+ "\n");
            printTxt.setText(printTxt.getText()+ "                                                       Tangga : "+date);
            printTxt.setText(printTxt.getText()+ "\n");
             printTxt.setText(printTxt.getText()+ "                                                       Kasir : "+kasir);
             printTxt.setText(printTxt.getText()+ "\n");
            printTxt.setText(printTxt.getText()+ "Nama Barang" + "\t" + "Harga" + "\t" + "Qty" + "\t" + "Total");
            printTxt.setText(printTxt.getText()+ "\n");
            printTxt.setText(printTxt.getText()+ "=====================================================\n");
             
            
            for (int i=0; i<model.getRowCount(); i++) {
                printTxt.setText(printTxt.getText()+ "\n");
                String nama = (String) model.getValueAt(i,1);
                String harga = (String) model.getValueAt(i,2);
                String qty = (String) model.getValueAt(i,3);
                int total1 = (int) model.getValueAt(i,4);
                
                printTxt.setText(printTxt.getText()+ nama + "\t" + harga + "\t" + qty + "\t" + total1);
                
            }
            printTxt.setText(printTxt.getText()+ "\n");
            printTxt.setText(printTxt.getText()+ "=====================================================\n");
            printTxt.setText(printTxt.getText()+ "\n");
            
            printTxt.setText(printTxt.getText()+ "Total : " + "\t" + total +  "\n");
            printTxt.setText(printTxt.getText()+ "Bayar : " + "\t" +bayar +  "\n");
            printTxt.setText(printTxt.getText()+ "Kembalian : " + "\t" + balance +  "\n");
            printTxt.setText(printTxt.getText()+ "\n");
            printTxt.setText(printTxt.getText()+ "=====================================================\n");
            printTxt.setText(printTxt.getText()+ "===========TERIMAKASIH ATAS KUNJUNGAN ANDA============\n");
            printTxt.setText(printTxt.getText()+ "=====================================================\n");
            
            printTxt.print();
        } catch (PrinterException ex) {
            Logger.getLogger(Struk.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
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
            java.util.logging.Logger.getLogger(Struk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Struk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Struk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Struk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Struk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea printTxt;
    // End of variables declaration//GEN-END:variables
}
