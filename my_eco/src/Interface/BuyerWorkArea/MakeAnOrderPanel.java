/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.BuyerWorkArea;

import Business.Employee.Buyer;
import Business.Enterprise.Entities.Buyorder;
import Business.Enterprise.Entities.Material;
import Business.Enterprise.ManufactureEnterprise;
import Business.Enterprise.SupplierEnterprise;
import Interface.BuyOrganizationDirectorWorkArea.BuyOrderAllocationJpanel;
//import Interface.BuyOrganizationDirectorWorkArea.BuyOrderAssignsJPanel;
import java.awt.CardLayout;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author keweiji
 */
public class MakeAnOrderPanel extends javax.swing.JPanel {

    /**
     * Creates new form MakeAnOrderPanel
     */
    private Buyer buyer;
    private JPanel userProcessContainer;
    private HashMap<ManufactureEnterprise, String> manufactureEnterprises;
    private HashMap<SupplierEnterprise, String> supplierEnterprises;
    private ManufactureEnterprise manufactureEnterprise;

    public MakeAnOrderPanel(JPanel userProcessContainer, Buyer buyer, ManufactureEnterprise manufactureEnterprise, HashMap<ManufactureEnterprise, String> manufactureEnterprises, HashMap<SupplierEnterprise, String> supplierEnterprises) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.buyer = buyer;
        this.manufactureEnterprise = manufactureEnterprise;
        this.manufactureEnterprises = manufactureEnterprises;
        this.supplierEnterprises = supplierEnterprises;
        populateorders();
        this.setOpaque(false);
        
        
    }

    public void populateorders() {
        DefaultTableModel model = (DefaultTableModel) Ordertable.getModel();
        model.setRowCount(0);
        System.out.println("this orders size:" + buyer.getBuyerorders().size());
        for (Buyorder order : buyer.getBuyerorders()) {
            if (order.isIsDelivered() == false) {
                Object[] row = new Object[2];
                row[0] = order;
                row[1] = order.getMaterials().size();
                model.addRow(row);
            }
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
        Ordertable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SourceTable = new javax.swing.JTable();
        checkSiblingsjButton2 = new javax.swing.JButton();
        checkSupplierjButton3 = new javax.swing.JButton();
        sbjButton4 = new javax.swing.JButton();
        supplierjButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(51, 51, 51));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Ordertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "BuyOrder Id", "Items Amounts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Ordertable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 620, 130));

        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton1.setText("Show Detail");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 140, -1));

        SourceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Location", "Source Name", "Enough Material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(SourceTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, 140));

        checkSiblingsjButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        checkSiblingsjButton2.setText("Check All Siblings");
        checkSiblingsjButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSiblingsjButton2ActionPerformed(evt);
            }
        });
        add(checkSiblingsjButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 170, -1));

        checkSupplierjButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        checkSupplierjButton3.setText("Check All Suppliers");
        checkSupplierjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSupplierjButton3ActionPerformed(evt);
            }
        });
        add(checkSupplierjButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 170, -1));

        sbjButton4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        sbjButton4.setText("Get From Sibling");
        sbjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbjButton4ActionPerformed(evt);
            }
        });
        add(sbjButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 170, -1));

        supplierjButton5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        supplierjButton5.setText("Get From Suppliers");
        supplierjButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierjButton5ActionPerformed(evt);
            }
        });
        add(supplierjButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 170, -1));

        jButton2.setText("<<back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void checkSiblingsjButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSiblingsjButton2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
        model.setRowCount(0);
        try {
            int index = Ordertable.getSelectedRow();
            Buyorder order = (Buyorder) Ordertable.getValueAt(index, 0);
            sbjButton4.setEnabled(true);
            supplierjButton5.setEnabled(false);
            popsiblings(order);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select an order" + e.getMessage());
            return;
        }


    }//GEN-LAST:event_checkSiblingsjButton2ActionPerformed

    private void checkSupplierjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSupplierjButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
        model.setRowCount(0);
        sbjButton4.setEnabled(false);
        supplierjButton5.setEnabled(true);

//                DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
//        model.setRowCount(0);
        try {
            int index = Ordertable.getSelectedRow();
            Buyorder order = (Buyorder) Ordertable.getValueAt(index, 0);
//            sbjButton4.setEnabled(true);
//            supplierjButton5.setEnabled(false);
            polulatesuppliers(order);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select an order" + e.getMessage());
            return;
        }


    }//GEN-LAST:event_checkSupplierjButton3ActionPerformed

    private void supplierjButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierjButton5ActionPerformed
        // TODO add your handling code here:
        try {
            int orderindex = Ordertable.getSelectedRow();
            int enterpriseindex = SourceTable.getSelectedRow();
            Buyorder order = (Buyorder) Ordertable.getValueAt(orderindex, 0);
            if ((Boolean) (SourceTable.getValueAt(enterpriseindex, 2)) == false) {
                JOptionPane.showMessageDialog(null, "this enterprise has no enough material");
                return;
            } else {

                SupplierEnterprise supplierEnterprise = (SupplierEnterprise) SourceTable.getValueAt(enterpriseindex, 1);
                supplierEnterprise.getBuyorders().add(order);
                
            }

            order.setIsDelivered(true);
            populateorders();
            DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
            model.setRowCount(0);
            sbjButton4.setEnabled(false);
            supplierjButton5.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please select a order, a enterprise to continue" + e.getMessage());
        }

    }//GEN-LAST:event_supplierjButton5ActionPerformed

    private void sbjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbjButton4ActionPerformed
        // TODO add your handling code here:

        try {
            int orderindex = Ordertable.getSelectedRow();
            int enterpriseindex = SourceTable.getSelectedRow();
            Buyorder order = (Buyorder) Ordertable.getValueAt(orderindex, 0);
            if ((Boolean) (SourceTable.getValueAt(enterpriseindex, 2)) == false) {
                JOptionPane.showMessageDialog(null, "this enterprise has no enough material");
                return;
            } else {
                ManufactureEnterprise manufactureEnterprise = (ManufactureEnterprise) SourceTable.getValueAt(enterpriseindex, 1);
                for (Material material : order.getMaterials().keySet()) {
                    int needamounts = order.getMaterials().get(material);
                    int theyhave = manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().get(material);
                    theyhave = theyhave - needamounts;
                    manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().put(material, theyhave);

                    if (!this.manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().containsKey(material)) {
                        this.manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().put(material, needamounts);
                    } else {
                        int alreadyhave = this.manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().get(material);
                        alreadyhave = alreadyhave + needamounts;
                        this.manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap().put(material, alreadyhave);
                    }

                }
            }

            order.setIsDelivered(true);
            populateorders();
            DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
            model.setRowCount(0);
            sbjButton4.setEnabled(false);
            supplierjButton5.setEnabled(false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please select a order, a enterprise to continue" + e.getMessage());
        }
    }//GEN-LAST:event_sbjButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            int index = Ordertable.getSelectedRow();
            Buyorder order =(Buyorder)Ordertable.getValueAt(index, 0);
                                        userProcessContainer.add("buyorderallocation", new OrderDetailJPanel(userProcessContainer, order));
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select an order");
            return;
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
                userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton2ActionPerformed
    public void popsiblings(Buyorder buyorder) {
        DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
        model.setRowCount(0);

        for (ManufactureEnterprise manufactureEnterprise : this.manufactureEnterprises.keySet()) {
            if (manufactureEnterprise == this.manufactureEnterprise) {
                continue;
            }
            Object[] row = new Object[3];
            row[0] = this.manufactureEnterprises.get(manufactureEnterprise);
            row[1] = manufactureEnterprise;
            HashMap<Material, Integer> avaliableMaterialInthisEnterprise = manufactureEnterprise.getWarehouse().getAvaliableMaterialHashMap();
            HashMap<Material, Integer> needHashMap = buyorder.getMaterials();

            for (Material material : needHashMap.keySet()) {
                if (!avaliableMaterialInthisEnterprise.containsKey(material) || avaliableMaterialInthisEnterprise.get(material) < needHashMap.get(material)) {
                    row[2] = false;
                    break;
                } else {
                    row[2] = true;
                }
            }
//            row[2] = false;

            model.addRow(row);

        }

    }

    public void polulatesuppliers(Buyorder order) {
        DefaultTableModel model = (DefaultTableModel) SourceTable.getModel();
        model.setRowCount(0);

        for (SupplierEnterprise supplierEnterprise : this.supplierEnterprises.keySet()) {

            Object[] row = new Object[3];
            row[0] = this.supplierEnterprises.get(supplierEnterprise);
            row[1] = supplierEnterprise;
            HashMap<Material, Integer> avaliableMaterialInthisEnterprise = supplierEnterprise.getAvaliableMaterialHashMap();
            HashMap<Material, Integer> needHashMap = order.getMaterials();

            for (Material material : needHashMap.keySet()) {
                if (!avaliableMaterialInthisEnterprise.containsKey(material) || avaliableMaterialInthisEnterprise.get(material) < needHashMap.get(material)) {
                    row[2] = false;
                    break;
                } else {
                    row[2] = true;
                }
            }
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Ordertable;
    private javax.swing.JTable SourceTable;
    private javax.swing.JButton checkSiblingsjButton2;
    private javax.swing.JButton checkSupplierjButton3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton sbjButton4;
    private javax.swing.JButton supplierjButton5;
    // End of variables declaration//GEN-END:variables
}
