/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WarehouseDirector;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.Buyorder;
import Business.Enterprise.Entities.SupplierWarehouse;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import Interface.DeliveryDirector.SelectDriver;

/**
 *
 * @author amber
 */
public class vieworders extends javax.swing.JPanel {

    /**
     * Creates new form vieworders
     */
    JPanel containerJPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    public vieworders(JPanel containerJPanel, UserAccount account,Organization organization,Enterprise enterprise) {
        initComponents();
        this.setOpaque(false);
        this.containerJPanel = containerJPanel;
        this.account = account;
        this.organization =  organization;
        this.enterprise= enterprise;
        populateTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderjTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Vrinda", 1, 36)); // NOI18N
        jLabel1.setText("View Orders");

        OrderjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orderid", "Enterprise", "Is reveived by others"
            }
        ));
        jScrollPane1.setViewportView(OrderjTable);

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(189, 189, 189)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addGap(114, 114, 114))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        containerJPanel.remove(this);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.previous(containerJPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       int selectedrow = OrderjTable.getSelectedRow();
       if(selectedrow>=0)
        {
            if(OrderjTable.getValueAt(selectedrow, 2) == "YES"){
                JOptionPane.showMessageDialog(null, "This order is operating", "Warning", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
            Buyorder b=(Buyorder)OrderjTable.getValueAt(selectedrow, 0);
            AllocationOrder mpcjp = new AllocationOrder(containerJPanel ,account,organization,enterprise,b);
            containerJPanel.add("WarehouseManagement",mpcjp);
            CardLayout layout = (CardLayout)containerJPanel.getLayout();
            layout.next(containerJPanel);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) OrderjTable.getModel();
        model.setRowCount(0);
        for (Buyorder b : ((SupplierEnterprise)enterprise).getBuyorders()) {
            Object[] row = new Object[3];
            row[0] = b;
            row[1] = b.getEnterprise();
            if(b.getReOrganization() == null){
                row[2] = "NO";
            }
            else{
                row[2] = "YES";
            }
            model.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
