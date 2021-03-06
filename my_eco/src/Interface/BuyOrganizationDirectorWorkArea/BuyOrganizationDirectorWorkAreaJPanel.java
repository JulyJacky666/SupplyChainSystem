/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BuyOrganizationDirectorWorkArea;

import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Organization.Organization;
import Business.Organization.PurchaseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class BuyOrganizationDirectorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form BuyOrganizationDirectorWorkAreaJPanel
     */
    private ManufactureEnterprise manufactureEnterprise;
    private JPanel userProcessContainer;
    private PurchaseOrganization purchaseOrganization;
    private UserAccount account;

    public BuyOrganizationDirectorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization) {
        initComponents();
        this.manufactureEnterprise = (ManufactureEnterprise) enterprise;
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.purchaseOrganization = (PurchaseOrganization) organization;
        System.out.println("this organization is null?" + organization == null);
        this.setOpaque(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calculatejButton1 = new javax.swing.JButton();
        allocation = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        calculatejButton1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        calculatejButton1.setText("Buying Order Calculation");
        calculatejButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculatejButton1ActionPerformed(evt);
            }
        });
        add(calculatejButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, 50));

        allocation.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        allocation.setText("Order allocation");
        allocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allocationActionPerformed(evt);
            }
        });
        add(allocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 250, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void calculatejButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculatejButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.add("buyordercalculate", new BuyingOrderCalculattionPanel(userProcessContainer, manufactureEnterprise));
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_calculatejButton1ActionPerformed

    private void allocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allocationActionPerformed
        // TODO add your handling code here:
        userProcessContainer.add("buyorderallocation", new BuyOrderAllocationJpanel(userProcessContainer, purchaseOrganization, manufactureEnterprise));
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_allocationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allocation;
    private javax.swing.JButton calculatejButton1;
    // End of variables declaration//GEN-END:variables
}
