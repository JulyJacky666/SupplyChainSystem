/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SalesmanWorkarea;

import Business.Employee.Customer;
import Business.Employee.Salesman;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Entities.Product;
import Business.Enterprise.Entities.SalesOrder;
import Business.Enterprise.SalesEnterprise;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author amber
 */
public class OrderLisitJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrderList
     */
    private JPanel userProcessContainer;
    private SalesOrganization organization;
    private SalesEnterprise enterprise;
    private UserAccount userAccount;
    public OrderLisitJPanel(JPanel userProcessContainer, UserAccount account, SalesOrganization organization, SalesEnterprise enterprise) {
        initComponents();
        this.setOpaque(false);
        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        populateTable();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        OrderjTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));

        OrderjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OderID", "Customer", "Price"
            }
        ));
        jScrollPane1.setViewportView(OrderjTable);
        if (OrderjTable.getColumnModel().getColumnCount() > 0) {
            OrderjTable.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("<<back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(158, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel) OrderjTable.getModel();
        
        model.setRowCount(0);
        for (SalesOrder salesOrder : ((Salesman)userAccount.getEmployee()).getSalesOrderDictory().getProductsDict()){
            Object[] row = new Object[3];
            row[0] = salesOrder.getOrderid();
            row[1] = salesOrder.getCustomer();
            double totalprivce = 0.0;
            for(Product product : salesOrder.getItems().keySet()){
                totalprivce +=  product.getSalesprice() * salesOrder.getItems().get(product);
            }
            row[2] = totalprivce;        
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrderjTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
