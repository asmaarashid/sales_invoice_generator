
package com.asmaasig.ig.view;

import com.asmaasig.ig.control.Controller;
import com.asmaasig.ig.model.Header;
import com.asmaasig.ig.model.HeaderTableModel;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Frame extends javax.swing.JFrame {

    public Frame() {
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

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(controller);
        //invoiceTable.setModel(getInvoicesTableModel());
        jScrollPane2 = new javax.swing.JScrollPane();
        lineTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invNumLabel = new javax.swing.JLabel();
        invDateLabel = new javax.swing.JLabel();
        customerLabel = new javax.swing.JLabel();
        invTotalLabel = new javax.swing.JLabel();
        createInvButton = new javax.swing.JButton();
        createInvButton.addActionListener(controller);
        deleteInvButton = new javax.swing.JButton();
        deleteInvButton.addActionListener(controller);
        addItemButton = new javax.swing.JButton();
        addItemButton.addActionListener(controller);
        deleteItemButton = new javax.swing.JButton();
        deleteItemButton.addActionListener(controller);
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadFileMenuItem = new javax.swing.JMenuItem();
        loadFileMenuItem.addActionListener(controller);
        saveFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem.addActionListener(controller);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoiceTable);

        lineTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(lineTable);

        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("Invoice Number");

        jLabel2.setForeground(new java.awt.Color(102, 0, 153));
        jLabel2.setText("Invoice Date");

        jLabel3.setForeground(new java.awt.Color(102, 0, 153));
        jLabel3.setText("Customer Name");

        jLabel4.setForeground(new java.awt.Color(102, 0, 153));
        jLabel4.setText("Invoice Total");

        invNumLabel.setText("jLabel5");

        invDateLabel.setText("jLabel6");

        customerLabel.setText("jLabel7");

        invTotalLabel.setText("jLabel8");

        createInvButton.setBackground(new java.awt.Color(204, 204, 255));
        createInvButton.setText("Create Invoice");

        deleteInvButton.setBackground(new java.awt.Color(204, 204, 255));
        deleteInvButton.setText("Delete Invoice");

        addItemButton.setBackground(new java.awt.Color(204, 204, 255));
        addItemButton.setText("Add New Item");

        deleteItemButton.setBackground(new java.awt.Color(204, 204, 255));
        deleteItemButton.setText("Delete Item");
        deleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        loadFileMenuItem.setText("Load File");
        jMenu1.add(loadFileMenuItem);

        saveFileMenuItem.setText("Save File");
        jMenu1.add(saveFileMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(createInvButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteInvButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(invTotalLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                                .addComponent(customerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(invDateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(invNumLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addItemButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteItemButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invNumLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customerLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invTotalLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvButton)
                    .addComponent(deleteInvButton)
                    .addComponent(addItemButton)
                    .addComponent(deleteItemButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteItemButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton createInvButton;
    private javax.swing.JLabel customerLabel;
    private javax.swing.JButton deleteInvButton;
    private javax.swing.JButton deleteItemButton;
    private javax.swing.JLabel invDateLabel;
    private javax.swing.JLabel invNumLabel;
    private javax.swing.JLabel invTotalLabel;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable lineTable;
    private javax.swing.JMenuItem loadFileMenuItem;
    private javax.swing.JMenuItem saveFileMenuItem;
    // End of variables declaration//GEN-END:variables
    
    //objects declaration
    private ArrayList<Header> invoices;
    private Controller controller = new Controller(this);
    private HeaderTableModel invoicesTableModel;
    
    // controller getter
    public Controller getController() {
        return controller;
    }
    
    // invoices getters and setters
    public ArrayList<Header> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Header> invoices) {
        this.invoices = invoices;
    }

    public HeaderTableModel getInvoicesTableModel() {
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(HeaderTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }
    
    //labels getters
    public JLabel getCustomerLabel() {
        return customerLabel;
    }

    public JLabel getInvDateLabel() {
        return invDateLabel;
    }

    public JLabel getInvNumLabel() {
        return invNumLabel;
    }

    public JLabel getInvTotalLabel() {
        return invTotalLabel;
    }
    
    // tables getters
    public JTable getInvoiceTable() {
        return invoiceTable;
    }
    
    public JTable getLineTable() {
        return lineTable;
    }

    // method to determining the next invoice number to use
    public int whatsNextInvoiceIndex(){
        int nextInvIndex = 0;
        for(Header invoice : invoices){
            if (invoice.getNum()> nextInvIndex){
                nextInvIndex = invoice.getNum();
            }
        
        }
        //adding 1 to the last invoice number
        return nextInvIndex + 1;
    }
     
    
}
