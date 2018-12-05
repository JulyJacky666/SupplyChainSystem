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
public class SalesEnterpriseDirectorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SalesAndBuyDirectorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private SalesEnterprise enterprise;
//    private SalesOrganization salesorganization;
    private HashMap<ManufactureEnterprise,String> allManufactureEnterprises;

    public SalesEnterpriseDirectorWorkAreaJPanel(JPanel userProcessContainer, SalesEnterprise enterprise, HashMap<ManufactureEnterprise,String> allManufactureEnterprises) {

        initComponents();
        this.userProcessContainer = userProcessContainer;        
        this.enterprise = enterprise;
        this.allManufactureEnterprises= allManufactureEnterprises;
        System.out.println(enterprise.getName());
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

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Deliver Sales Order to Manufacture");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 250, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        AssignSlaesOrderToManuJPanel assignSlaesOrderToManuJPanel = new AssignSlaesOrderToManuJPanel(userProcessContainer, enterprise,allManufactureEnterprises);
                userProcessContainer.add("manageOrganizationJPanel", assignSlaesOrderToManuJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
