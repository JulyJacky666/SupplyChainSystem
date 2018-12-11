/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CustomerAssistantWorkArea;

import Business.Area.Area;
import Business.Employee.Customer;
import Business.Employee.CustomerAssisatant;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.ManufactureEnterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class ManageOrders extends javax.swing.JPanel {

    /**
     * Creates new form CustomerOrdersDetail
     */
    private JPanel userProcessContainer;
//      private Area area;
    private ArrayList<Area> areas;
    private UserAccount account;
//      private  CustomerAssistant customerAssistant;
    private CustomerAssisatant customerAssistant;
    private SalesOrder order;
    private Customer customer;
    private HashMap<ManufactureEnterprise, String> allManufactureEnterprises;

    public ManageOrders(JPanel userProcessContainer, UserAccount account, ArrayList<Area> areas, SalesOrder order, Customer customer, HashMap<ManufactureEnterprise, String> allManufactureEnterprises) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.areas = areas;
        this.order = order;
        this.account = account;
        this.customer = customer;
        this.allManufactureEnterprises = allManufactureEnterprises;
        populatetable();
        this.setOpaque(false);
//        account=account;
//        customerAssistant=customerAssistant;
    }

    public void populatetable() {

        this.locationjLabel2.setText("Delivered to:" + this.order.getDestinationState());
        this.isreadyforcustomer.setText("Complete: " + this.order.isIsReadyToCustomer());
        if (this.order.isIsReadyToCustomer() == true) {
            isreadyforcustomer.setForeground(Color.green);
        } else {
            isreadyforcustomer.setForeground(Color.red);
        }
        this.iscalculated.setText("Caculated:  " + this.order.isIscalcutated());
        if (this.order.isIscalcutated() == true) {
            iscalculated.setForeground(Color.green);
        } else {
            iscalculated.setForeground(Color.red);
        }

        this.isdeliveredlable.setText("Delivered To manufacture: " + this.order.isIsdeliveredtomanufac());
             if (this.order.isIsdeliveredtomanufac() == true) {
            isdeliveredlable.setForeground(Color.green);
        } else {
            isdeliveredlable.setForeground(Color.red);
        }

        this.manuBox.removeAllItems();
        for (ManufactureEnterprise manufactureEnterprise : this.allManufactureEnterprises.keySet()) {
            manuBox.addItem(manufactureEnterprise);
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Product product : order.getItems().keySet()) {
            Object[] row = new Object[2];
            row[0] = product;
            row[1] = order.getItems().get(product);
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        locationjLabel2 = new javax.swing.JLabel();
        isreadyforcustomer = new javax.swing.JLabel();
        isdeliveredlable = new javax.swing.JLabel();
        iscalculated = new javax.swing.JLabel();
        manuBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product", "Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 590, 140));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Return  product to");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 170, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Order Details");
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 22));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 260, 30));

        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton2.setText("<<Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        locationjLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        locationjLabel2.setText("Delivered to:");
        add(locationjLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 150, 30));

        isreadyforcustomer.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        isreadyforcustomer.setText("Complete: ");
        add(isreadyforcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 120, 30));

        isdeliveredlable.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        isdeliveredlable.setText("Delivered To manufacture:");
        add(isdeliveredlable, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 190, 40));

        iscalculated.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        iscalculated.setText("Caculated: ");
        add(iscalculated, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 90, 40));

        manuBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        manuBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        manuBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manuBoxActionPerformed(evt);
            }
        });
        add(manuBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 340, 160, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel2.setText("Manufactuer:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.order.isIsReadyToCustomer() == true) {
            try {

                int index = jTable1.getSelectedRow();
                Product product = (Product) jTable1.getValueAt(index, 0);
                int amount = (int) jTable1.getValueAt(index, 1);
                ManufactureEnterprise manufactureEnterprise = (ManufactureEnterprise) manuBox.getSelectedItem();
                if (!manufactureEnterprise.getReturnedProductHashMap().containsKey(product)) {
                    manufactureEnterprise.getReturnedProductHashMap().put(product, amount);

                } else {
                    int oldamount = manufactureEnterprise.getReturnedProductHashMap().get(product);
                    manufactureEnterprise.getReturnedProductHashMap().put(product, amount + oldamount);

                }
                JOptionPane.showMessageDialog(null, "return sucess!");
                CustomerAssisatant customerAssisatant = (CustomerAssisatant) this.account.getEmployee();
                customerAssisatant.setServedcounts(customerAssisatant.getServedcounts() + 1);
                customerAssisatant.getServedCustomer().add(this.customer);
                return;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "please select a product and a Manufacture" + e.getMessage());
                return;
            }
        } else {
            JOptionPane.showMessageDialog(null, "this order is not completed yet. You cant return product");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void manuBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manuBoxActionPerformed
        // TODO add your handling code here:
//        Area area = (Area) areaJComboBox.getSelectedItem();
//        if(area != null){
//            populateCustomer(area);
//        }

    }//GEN-LAST:event_manuBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iscalculated;
    private javax.swing.JLabel isdeliveredlable;
    private javax.swing.JLabel isreadyforcustomer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel locationjLabel2;
    private javax.swing.JComboBox manuBox;
    // End of variables declaration//GEN-END:variables
}
