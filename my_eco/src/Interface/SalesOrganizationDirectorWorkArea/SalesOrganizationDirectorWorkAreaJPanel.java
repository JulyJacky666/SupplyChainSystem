/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SalesOrganizationDirectorWorkArea;

import Business.Enterprise.Enterprise;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.Organization;
import Business.Organization.ProductOrganization;
import Business.Organization.SalesOrganization;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author keweiji
 */
public class SalesOrganizationDirectorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesAndBuyDirectorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private SalesEnterprise enterprise;
    private SalesOrganization salesorganization;
    private HashMap<ManufactureEnterprise,String> allManufactureEnterprises;

    public SalesOrganizationDirectorWorkAreaJPanel(JPanel userProcessContainer, Organization organization,SalesEnterprise enterprise, HashMap<ManufactureEnterprise,String> allManufactureEnterprises) {

        initComponents();
        this.userProcessContainer = userProcessContainer;        
        this.enterprise = enterprise;
        this.allManufactureEnterprises= allManufactureEnterprises;
        this.salesorganization = (SalesOrganization)organization;
        System.out.println(enterprise.getName());
        this.setOpaque(false);
//        System.out.println("org:"+organization.getName());
//        System.out.println(this.salesAndBuysOrganization.getName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jButton2.setText("Deliver Sales Order to Manufacture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 350, 60));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jButton1.setText("Salesman Performance Analysis");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 350, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AssignSlaesOrderToManuJPanel assignSlaesOrderToManuJPanel = new AssignSlaesOrderToManuJPanel(userProcessContainer, enterprise,allManufactureEnterprises);
                userProcessContainer.add("manageOrganizationJPanel", assignSlaesOrderToManuJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                        userProcessContainer.add("manageOrganizationJPanel", new analysisSalesmanJpanel(userProcessContainer, salesorganization));
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
