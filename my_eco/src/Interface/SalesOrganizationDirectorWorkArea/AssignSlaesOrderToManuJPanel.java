/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SalesOrganizationDirectorWorkArea;

import Business.Employee.Employee;
import Business.Employee.Salesman;
import Business.Employee.Worker;
import Business.Enterprise.Entities.ManufactureTask;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.Organization;
import Business.Organization.ProductOrganization;
import Business.Organization.SalesOrganization;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class AssignSlaesOrderToManuJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignSlaesOrderToManuJPanel
     */
//    private SalesOrganization salesOrganization;
    private SalesEnterprise salesEnterprise;
    private JPanel userProcessContainer;
    private HashMap<ManufactureEnterprise, String> allManufactureEnterprises;

    public AssignSlaesOrderToManuJPanel(JPanel userProcessContainer, SalesEnterprise salesEnterprise, HashMap<ManufactureEnterprise, String> allManufactureEnterprises) {
        this.userProcessContainer = userProcessContainer;
//        this.salesOrganization = salesOrganization;
        this.salesEnterprise = salesEnterprise;
        this.allManufactureEnterprises = allManufactureEnterprises;
        initComponents();
//          System.out.println(this.salesOrganization.getName()+111);
        populateorderstable();
        populatemanus();
        this.setOpaque(false);

    }

    public void populateorderstable() {
        DefaultTableModel model = (DefaultTableModel) ordersjTable1.getModel();
        model.setRowCount(0);
        for (SalesOrder salesOrder : this.salesEnterprise.getSalesOrdersDirectoryArrayList()) {
            if (salesOrder.isIsdeliveredtomanufac() == false) {
                Object[] row = new Object[4];
                row[0] = salesOrder;
//                row[1] = String.valueOf(salesOrder.isIsEmergency());
                row[1] = salesOrder.getCustomer().getName();
                row[2] = salesOrder.getDestinationState();
                row[3] = salesOrder.getItems().size();

                model.addRow(row);
            }
//        for (Organization organization : this.salesEnterprise.getOrganizationDirectory().getOrganizationList()) {
//            for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()) {
//                if (employee.getRolenumber() == 2) {
//                    for (SalesOrder salesOrder : ((Salesman) employee).getSalesOrderDictory().getSalesorders()) {
//                        if (salesOrder.isIsdeliveredtomanufac() == false) {
//                            Object[] row = new Object[5];
//                            row[0] = salesOrder;
//                            row[1] = String.valueOf(salesOrder.isIsEmergency());
//                            row[2] = salesOrder.getCustomer().getName();
//                            row[3] = salesOrder.getDestinationState();
//                            row[4] = salesOrder.getItems().size();
//
//                            model.addRow(row);
//                        }
//                    }
//
//                }
//            }
//        }

        }

    }

    public void populatemanus() {
        DefaultTableModel model = (DefaultTableModel) manusjTable2.getModel();
        model.setRowCount(0);
        for (ManufactureEnterprise manufactureEnterprise : this.allManufactureEnterprises.keySet()) {
            Object[] row = new Object[4];
            row[0] = this.allManufactureEnterprises.get(manufactureEnterprise);
            row[1] = manufactureEnterprise;
            int workablenumer = 0;
            for (Organization organization : manufactureEnterprise.getOrganizationDirectory().getOrganizationList()) {
                if (organization instanceof ProductOrganization) {
                    for (Worker worker : organization.getEmployeeDirectory().getworkerArrayList()) {
                        if (worker.isWorkable() == true) {
                            workablenumer += 1;
                        }
                    }
                }
            }
            row[2] = workablenumer;
            int taskondoing = 0;
            for (ManufactureTask manufacturetask : manufactureEnterprise.getManufactureTasksdirectory()) {
                if (manufacturetask.getExcuted() == true && manufacturetask.getCompleted() == false) {
                    taskondoing += 1;
                }
            }
            row[3] = taskondoing;

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
        ordersjTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        manusjTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ordersjTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order id", "Customer Name", "Destination", "Amount of Items"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ordersjTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 520, 130));

        manusjTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Area", "Manufactuer Name", "Workers avaliable", "Tasks on doing"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(manusjTable2);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 520, 150));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Deliver the selected order to selected Manu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 320, 40));

        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton3.setText("<<back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int orderindex = ordersjTable1.getSelectedRow();
        int manusindex = manusjTable2.getSelectedRow();

        SalesOrder order = (SalesOrder) ordersjTable1.getValueAt(orderindex, 0);
        ManufactureEnterprise enterprise = (ManufactureEnterprise) manusjTable2.getValueAt(manusindex, 1);
        enterprise.getReceivedOrders().add(order);
        order.setIsdeliveredtomanufac(true);
        JOptionPane.showMessageDialog(null, "Successfully deliver order to Manufactures");
        populateorderstable();
        populatemanus();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
                        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable manusjTable2;
    private javax.swing.JTable ordersjTable1;
    // End of variables declaration//GEN-END:variables
}
