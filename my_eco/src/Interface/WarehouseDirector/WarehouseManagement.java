/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WarehouseDirector;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author amber
 */
public class WarehouseManagement extends javax.swing.JPanel {

    /**
     * Creates new form WarehouseManagement
     */
    JPanel containerJPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    public WarehouseManagement(JPanel c,UserAccount account,Organization organization,
    Enterprise enterprise) {
        initComponents();
        this.setOpaque(false);
        this.containerJPanel =c;
        this.account = account;
        this.organization =  organization;
        this.enterprise= enterprise;
        System.out.print(organization);
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
        CreateWarehousejButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Warehouse Managment");

        CreateWarehousejButton.setFont(new java.awt.Font("Viner Hand ITC", 1, 16)); // NOI18N
        CreateWarehousejButton.setText("Create Warehouse");
        CreateWarehousejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateWarehousejButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Viner Hand ITC", 1, 16)); // NOI18N
        jButton2.setText("ADD Material To Warehouse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton4.setText("<<Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1)))
                .addContainerGap(159, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateWarehousejButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(CreateWarehousejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(76, 76, 76))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreateWarehousejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateWarehousejButtonActionPerformed
        // TODO add your handling code here:
        ViewWarehouse mpcjp = new ViewWarehouse(containerJPanel,account,organization,enterprise);
       containerJPanel.add("WarehouseManagement",mpcjp);
       CardLayout layout = (CardLayout)containerJPanel.getLayout();
       layout.next(containerJPanel);
    }//GEN-LAST:event_CreateWarehousejButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SelectWarehouse mpcjp = new SelectWarehouse(containerJPanel,account,organization,enterprise);
       containerJPanel.add("WarehouseManagement",mpcjp);
       CardLayout layout = (CardLayout)containerJPanel.getLayout();
       layout.next(containerJPanel);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        containerJPanel.remove(this);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.previous(containerJPanel);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateWarehousejButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
