/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WarehouseDirector;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author amber
 */
public class WarehouseDirector extends javax.swing.JPanel {

    /**
     * Creates new form WarehouseDirector
     */
    JPanel containerJPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    public WarehouseDirector(JPanel con, UserAccount account, Organization Organization,Enterprise enterprise) {
        initComponents();
        this.setOpaque(false);
        this.containerJPanel = con;
        this.account = account;
        this.organization = Organization;
        this.enterprise = enterprise;
        NamejLabel.setText(account.getUsername());
        init();
        init2();
    }
    
    public void init(){
        SupplierEnterprise supplierEnterpriser = (SupplierEnterprise) this.enterprise;
//        HashMap<Material,Integer> hashMap= supplierEnterpriser.getAvaliableMaterialHashMap();
        for(Material m:supplierEnterpriser.getMaterialDirectory().getMaterials()){
            supplierEnterpriser.getAvaliableMaterialHashMap().put(m, 2000);
        }
    }
     public void init2(){
         SupplierEnterprise supplierEnterpriser = (SupplierEnterprise) this.enterprise;
         WarehouseOrganization warehouseOrganization =(WarehouseOrganization)this.organization;
         for(Material m:supplierEnterpriser.getMaterialDirectory().getMaterials()){
             warehouseOrganization.getAvaliableMaterialHashMap().put(m, 2000);
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

        NamejLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CreateMjButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        NamejLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        NamejLabel.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel3.setText("WORKAREA");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setText("Hello,");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jButton1.setText("Order Allocation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        CreateMjButton.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        CreateMjButton.setText("Create Material");
        CreateMjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateMjButtonActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jButton4.setText("ADD MATERIAL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(355, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreateMjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(NamejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(326, 326, 326))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(NamejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CreateMjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        vieworders mpcjp = new vieworders(containerJPanel, account, organization, enterprise);
        containerJPanel.add("WarehouseManagement",mpcjp);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.next(containerJPanel);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CreateMjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateMjButtonActionPerformed
        // TODO add your handling code here:
        ViewCreateMaterial mpcjp = new ViewCreateMaterial(containerJPanel ,account,organization,enterprise);
        containerJPanel.add("WarehouseManagement",mpcjp);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.next(containerJPanel);
    }//GEN-LAST:event_CreateMjButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        AddMateralToWarehouse mpcjp = new AddMateralToWarehouse(containerJPanel,account,organization,enterprise);
        containerJPanel.add("WarehouseManagement",mpcjp);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.next(containerJPanel);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateMjButton;
    private javax.swing.JLabel NamejLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}