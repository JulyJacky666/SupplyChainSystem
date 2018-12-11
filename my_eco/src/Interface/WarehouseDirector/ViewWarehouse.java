/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.WarehouseDirector;

import Business.Employee.Customer;
import Business.Employee.Salesman;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.MaterialDirectory;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SupplierWarehouse;
import Business.Enterprise.Entities.Warehouse;
import Business.Enterprise.SupplierEnterprise;
import Business.Organization.Organization;
import Business.Organization.WarehouseOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amber
 */

public class ViewWarehouse extends javax.swing.JPanel {

    /**
     * Creates new form ViewWarehouse
     */
    JPanel containerJPanel;
    UserAccount account;
    Organization organization;
    Enterprise enterprise;
    public ViewWarehouse(JPanel c, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.setOpaque(false);
        this.containerJPanel = c;
        this.account = account;
        this.organization = organization;
        this.enterprise = enterprise;
        populateTable();
        System.out.println(organization);
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
        WarehousejTable = new javax.swing.JTable();
        CreatejButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(51, 51, 51));

        WarehousejTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Location", "Orgnaztion"
            }
        ));
        jScrollPane1.setViewportView(WarehousejTable);

        CreatejButton.setFont(new java.awt.Font("Al Bayan", 0, 14)); // NOI18N
        CreatejButton.setText("Create");
        CreatejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreatejButtonActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Al Bayan", 0, 14)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Stencil", 1, 36)); // NOI18N
        jLabel1.setText("View Warehouse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 332, Short.MAX_VALUE)
                .addComponent(CreatejButton)
                .addGap(329, 329, 329))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreatejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(85, 85, 85))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CreatejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreatejButtonActionPerformed
        // TODO add your handling code here:
       CreateWarehouse mpcjp = new CreateWarehouse(containerJPanel,account,organization,enterprise);
       containerJPanel.add("WarehouseManagement",mpcjp);
       CardLayout layout = (CardLayout)containerJPanel.getLayout();
       layout.next(containerJPanel);
    }//GEN-LAST:event_CreatejButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        containerJPanel.remove(this);
        CardLayout layout = (CardLayout)containerJPanel.getLayout();
        layout.previous(containerJPanel);
    }//GEN-LAST:event_jButton2ActionPerformed


    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) WarehousejTable.getModel();

        model.setRowCount(0);
        for (SupplierWarehouse w : ((WarehouseOrganization)organization).getSupplierWarehouseDictionary().getWarehouses()) {
            System.out.println(organization);
            Object[] row = new Object[3];
            row[0] = w;
            row[1] = w.getLocationString();
            row[2] = w.getOrganization();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreatejButton;
    private javax.swing.JTable WarehousejTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}