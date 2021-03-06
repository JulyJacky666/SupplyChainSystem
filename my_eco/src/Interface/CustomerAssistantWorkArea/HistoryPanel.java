/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.CustomerAssistantWorkArea;

import Business.Area.Area;
import Business.Employee.Customer;
import Business.Employee.CustomerAssisatant;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class HistoryPanel extends javax.swing.JPanel {

    /**
     * Creates new form HistoryPanel
     */
    private JPanel userProcessContainer;
//      private Area area;
    private ArrayList<Area> areas;
    private UserAccount account;
//      private  CustomerAssistant customerAssistant;
    private CustomerAssisatant customerAssistant;

    public HistoryPanel(JPanel userProcessContainer, CustomerAssisatant customerAssistant) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.customerAssistant = customerAssistant;
        populate();
        this.setOpaque(false);
    }

    public void populate() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (Customer customer : customerAssistant.getServedCustomer()) {
            Object[] row = new Object[2];
            row[0] = customer.getName();
            row[1] = customer.getAddress();
            model.addRow(row);
        }

        peoplejLabel2.setText("Total served people: " + customerAssistant.getServedCustomer().size());
        countsjLabel3.setText(String.valueOf(customerAssistant.getServedcounts()));
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        peoplejLabel2 = new javax.swing.JLabel();
        countsjLabel3 = new javax.swing.JLabel();

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
                "Customer", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 510, 120));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 36)); // NOI18N
        jLabel1.setText("Served Customers");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, -1, -1));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));

        peoplejLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        peoplejLabel2.setText("Total served people:");
        add(peoplejLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 160, -1));

        countsjLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        countsjLabel3.setText("Total served times:");
        add(countsjLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countsjLabel3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel peoplejLabel2;
    // End of variables declaration//GEN-END:variables
}
